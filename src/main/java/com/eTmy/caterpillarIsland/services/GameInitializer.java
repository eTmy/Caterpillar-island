package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.Survival;
import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Animal;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;
import main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores.Wolf;

import java.util.*;

public class GameInitializer {
    public static List<Class<?>> usedGameObjectClasses;

    public static void main(String[] args) {
        //Получить настройки
        initializeClasses();
        GameObjects.generateGameFields();
        System.out.println("Инициализация обьектов завершенна");

        System.out.println("Вероятности сьесть животное: ");
        Survival.getInstance().getSurvivalList().forEach(System.out::println);

        List<ItemObject> listAnimals = new ArrayList<>();

        GameObjects.getGameObjects().forEach((k, v) -> v.forEach(itemObject -> {
            if (itemObject instanceof Animal) {
                listAnimals.add(itemObject);
            }
        }));

        listAnimals.forEach(itemObject -> GameHandler.makeDailyActivity((Animal) itemObject));
    }

    public static void initializeClasses() {
        usedGameObjectClasses = ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores");
        usedGameObjectClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores"));
        usedGameObjectClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.plants"));
    }


}
