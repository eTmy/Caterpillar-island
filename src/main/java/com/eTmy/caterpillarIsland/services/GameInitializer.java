package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.WorldMap;
import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;

import java.lang.reflect.Constructor;
import java.util.List;

public class GameInitializer {
    public static List<Class<?>> initializedClasses;

    public static void main(String[] args) {
        initializeClasses();
        WorldMap.generateObjects();

        System.out.println("Инициализация обьектов завершенна");
        //Получить настройки
    //    WorldMap.generateWorldMap();

   //     WorldMap.fillWorldMap();
    //    WorldMap.printWorldMap();
        //Делать ходы пока возможно
    }

    public static void initializeClasses() {
        initializedClasses = ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores");
        initializedClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores"));
        initializedClasses.addAll(ClassFinder.find("main.java.com.eTmy.caterpillarIsland.objects.plants"));
    }

}
