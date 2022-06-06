package main.java.com.eTmy.caterpillarIsland;

import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;
import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
//import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public final class WorldMap {

    public static int MAP_WIDTH = 5;
    public static int MAP_HEIGHT = 5;

    private static ArrayList<ArrayList<ArrayList<ItemObject>>> textGraphicWorldMap = new ArrayList<>(MAP_WIDTH);

    public WorldMap() {
    }

    public static void generateWorldMap() {
        for (int x = 0; x < MAP_WIDTH; x++) {
            textGraphicWorldMap.add(x, new ArrayList<>(MAP_HEIGHT));
            for (int y = 0; y < MAP_HEIGHT; y++) {
                textGraphicWorldMap.get(x).add(y, new ArrayList<>());
            }
        }
    }

    public static void printWorldMap() {
        textGraphicWorldMap.forEach(arrayLists -> {
            arrayLists.forEach(itemObjects -> {
                if (itemObjects.size() > 0) {
                    System.out.print(" [" + itemObjects.get(0).toString() + "]");
                } else System.out.print(" [ ]");
            });
            System.out.println();
        });
    }



    public static void fillWorldMap() {
        GameObjects.getGameObjects().forEach((key, value) -> value.forEach(itemObject ->
                textGraphicWorldMap.get(itemObject.getPositionX()).get(itemObject.getPositionY()).add(itemObject)));
    }

    public static ArrayList<ArrayList<ArrayList<ItemObject>>> getTextGraphicWorldMap() {
        return textGraphicWorldMap;
    }




}

