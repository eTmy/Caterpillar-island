package main.java.com.eTmy.caterpillarIsland;

import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Animal;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;
import main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores.Bear;
import main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores.Boa;
import main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores.Wolf;
import main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores.Buffalo;
import main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores.Caterpillar;
import main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores.Duck;
import main.java.com.eTmy.caterpillarIsland.objects.plants.Corn;
import main.java.com.eTmy.caterpillarIsland.objects.plants.Wheat;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class WorldMap {

    public static int MAP_WIDTH = 5;
    public static int MAP_HEIGHT = 5;

    private static ArrayList<ArrayList<ArrayList<ItemObject>>> worldMap = new ArrayList<ArrayList<ArrayList<ItemObject>>>(MAP_WIDTH);
    private static final Map<String, ArrayList<ItemObject>> objectsCoordinates = new HashMap<>();

    public WorldMap() {
    }

    public static void generateWorldMap() {
        for(int x = 0; x < MAP_WIDTH; x++) {
            worldMap.add(x, new ArrayList<ArrayList<ItemObject>>(MAP_HEIGHT));
            for(int y = 0; y < MAP_HEIGHT; y++) {
                worldMap.get(x).add(y, new ArrayList<ItemObject>());
            }
        }
    }

    public static void printWorldMap(){
        worldMap.forEach(arrayLists -> {
            arrayLists.forEach(itemObjects -> {
                if (itemObjects.size() > 0) {
                    System.out.print(" ["+itemObjects.get(0).toString()+"]");
                }
                else System.out.print(" [ ]");
            });
            System.out.println("");
        });
    }

    public static void generateObjects(){
        //generate from settings

        addObjectCoordinate(new Wheat(0,0));
        addObjectCoordinate(new Buffalo(0,4));

        addObjectCoordinate(new Caterpillar(1,3));
        addObjectCoordinate(new Bear(1,1));
        addObjectCoordinate(new Wheat(1,2));

        addObjectCoordinate(new Duck(2,1));
        addObjectCoordinate(new Corn(2,2));

        addObjectCoordinate(new Caterpillar(3,4));

        addObjectCoordinate(new Wolf(4,2));
        addObjectCoordinate(new Boa(4,2));

    }

    public static void fillWorldMap(){
        objectsCoordinates.forEach((key, value) -> value.forEach(animal ->
                worldMap.get(animal.getPositionX()).get(animal.getPositionY()).add(animal)));
    }

    public static ArrayList<ArrayList<ArrayList<ItemObject>>> getWorldMap() {
        return worldMap;
    }

    public static Map<String, ArrayList<ItemObject>> getObjectsCoordinates() {
        return objectsCoordinates;
    }

    public static void addObjectCoordinate(@NotNull ItemObject itemObject){
        ArrayList<ItemObject> mapValue = objectsCoordinates.get(itemObject.getPositionKey());
        if (mapValue == null)
            objectsCoordinates.put(itemObject.getPositionKey(), new ArrayList(Arrays.asList(itemObject)));
        else {
            boolean result = mapValue.add(itemObject);
            if (result) {
                objectsCoordinates.put(itemObject.getPositionKey(), mapValue);
            }
        }
    }


}

