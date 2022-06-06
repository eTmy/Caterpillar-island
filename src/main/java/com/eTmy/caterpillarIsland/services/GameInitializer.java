package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.db.GameObjects;

import java.util.List;

public class GameInitializer {
    public static List<Class<?>> usedGameObjectClasses;

    public static void main(String[] args) {
        //Получить настройки
        initializeClasses();
        GameObjects.generateGameFields();

        System.out.println("Инициализация обьектов завершенна");

        //WorldMap.generateWorldMap();
        //WorldMap.fillWorldMap();
        //WorldMap.printWorldMap();
        //Делать ходы пока возможно
    }

    public static void initializeClasses() {
        usedGameObjectClasses = ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores");
        usedGameObjectClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores"));
        usedGameObjectClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.plants"));
    }

}
