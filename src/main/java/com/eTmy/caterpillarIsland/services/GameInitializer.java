package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.tasks.ActivityMaker;
import main.java.com.eTmy.caterpillarIsland.tasks.ObjectGenerator;
import main.java.com.eTmy.caterpillarIsland.tasks.StatisticPrinter;
import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Animal;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Plant;

import java.util.*;
import java.util.concurrent.Phaser;

public class GameInitializer {
    public static List<Class<?>> usedGameObjectClasses;
    public static Statistic statistic;
    public static Settings gameSettings;

    public static void main(String[] args) {
        int currentDay = 0;

        statistic = new Statistic();
        gameSettings = new Settings();

        initClasses();
        generateObjects(Animal.class);
        generateObjects(Plant.class);

        printStart();

        Phaser phaser = new Phaser(1);

        while (currentDay <= gameSettings.getMaxDays() && GameObjects.getCreatedObjectsCount(Animal.class) > 0) {
            statistic.setCurrentDay(currentDay);
            statistic.resetDayStatistic();

            runDay(phaser);
            currentDay++;
        }

        phaser.arriveAndDeregister();
        printTheEnd(currentDay);
    }

    public static void makeAnimalActivity() {
        GameObjects.getGameObjects().forEach((k, v) -> v.forEach(itemObject -> {
            if (itemObject instanceof Animal animal) {
                if (animal.isDead()) {
                    return;
                }
                GameHandler.makeDailyActivity(animal);
            }
        }));
    }

    public static void initClasses() {
        usedGameObjectClasses = ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores");
        usedGameObjectClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores"));
        usedGameObjectClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.plants"));
    }

    public static void generateObjects(Class<?> clazz) {
        GameObjects.generateGameFields(usedGameObjectClasses.stream().filter(aClass -> clazz.isAssignableFrom(aClass)).toList());
    }

    public static void printStart() {
        System.out.println(gameSettings.getDelimiterMessage());
        System.out.println("World is created! ");
        System.out.println("Size: " + gameSettings.getMapWidth() + " x " + gameSettings.getMapHeight());
        System.out.println("Animal population: " + GameObjects.getCreatedObjectsCount(Animal.class));
        System.out.println("Plant population: " + GameObjects.getCreatedObjectsCount(Plant.class));
        System.out.println("Max days: " + gameSettings.getMaxDays());
    }

    public static void printTheEnd(int currentDay) {
        System.out.println(gameSettings.getDelimiterMessage());
        System.out.println("Your colony has lasted " + currentDay + " days!");
        System.out.println("THE END!");
        System.out.println(gameSettings.getDelimiterMessage());
    }

    private static void runDay(Phaser phaser) {
        new Thread(new ObjectGenerator(phaser, Plant.class)).start();
        new Thread(new ActivityMaker(phaser)).start();
        phaser.arriveAndAwaitAdvance();
        new Thread(new StatisticPrinter(phaser)).start();
        phaser.arriveAndAwaitAdvance();

        GameObjects.updateCreatedObjects();
    }
}
