package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.WorldMap;

public class GameInitializer {

    public static void main(String[] args) {
        //Получить настройки
        WorldMap.generateWorldMap();
        WorldMap.generateObjects();
        WorldMap.fillWorldMap();
        WorldMap.printWorldMap();
        //Делать ходы пока возможно
    }

}
