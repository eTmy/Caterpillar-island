package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.Survival;
import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
import main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores.Wolf;
import main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores.Boar;

import java.util.List;

public class GameInitializer {
    public static List<Class<?>> usedGameObjectClasses;

    public static void main(String[] args) {
        //Получить настройки
        initializeClasses();
        GameObjects.generateGameFields();
        System.out.println("Инициализация обьектов завершенна");

        System.out.println("Вероятности сьесть животное: ");
        Survival.getInstance().getSurvivalList().forEach(System.out::println);

        System.out.println(Survival.getInstance().getEatChance(Wolf.class.getSimpleName(), "sda"));
    }

    public static void initializeClasses() {
        usedGameObjectClasses = ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores");
        usedGameObjectClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores"));
        usedGameObjectClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.plants"));
    }



}
