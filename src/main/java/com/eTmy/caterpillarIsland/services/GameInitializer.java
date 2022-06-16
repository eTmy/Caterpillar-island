package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.Survival;
import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Animal;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;

import java.util.*;

public class GameInitializer {
    public static List<Class<?>> usedGameObjectClasses;

    public static void main(String[] args) {
        //сделать настройки
        initClasses();
        GameObjects.generateGameFields();
        System.out.println("Objects generation is done");

        test();
    }

    public static void test() {
        List<ItemObject> listAnimals = new ArrayList<>();

        System.out.println("Survival chance: ");
        Survival.getInstance().getSurvivalList().forEach(System.out::println);

        GameObjects.getGameObjects().forEach((k, v) -> v.forEach(itemObject -> {
            if (itemObject instanceof Animal) {
                listAnimals.add(itemObject);
            }
        }));

        //добавить цикл роста растений
        listAnimals.forEach(itemObject -> {
            Animal animal = (Animal) itemObject;
            if (animal.isDead()) {
                System.out.println(animal + " doesn't make daily activity because it's dead!");
                return;
            }
            GameHandler.makeDailyActivity(animal);
        });

        GameObjects.updateCreatedObjects();
    }

    public static void initClasses() {
        usedGameObjectClasses = ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores");
        usedGameObjectClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores"));
        usedGameObjectClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.plants"));
    }


}
