package main.java.com.eTmy.caterpillarIsland;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;
import main.java.com.eTmy.caterpillarIsland.services.GameInitializer;
//import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class WorldMap {

    public static int MAP_WIDTH = 5;
    public static int MAP_HEIGHT = 5;

    private static ArrayList<ArrayList<ArrayList<ItemObject>>> textGraphicWorldMap = new ArrayList<>(MAP_WIDTH);
    private static final Map<String, ArrayList<ItemObject>> objectsCoordinates = new HashMap<>();

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

    public static void generateObjects() {
        //generate from settings
        for (int x = 0; x < MAP_WIDTH; x++) {
            for (int y = 0; y < MAP_HEIGHT; y++) {
                generateFieldObjects(x, y);
            }
        }

    }

    public static void fillWorldMap() {
        objectsCoordinates.forEach((key, value) -> value.forEach(itemObject ->
                textGraphicWorldMap.get(itemObject.getPositionX()).get(itemObject.getPositionY()).add(itemObject)));
    }

    public static ArrayList<ArrayList<ArrayList<ItemObject>>> getTextGraphicWorldMap() {
        return textGraphicWorldMap;
    }

    public static Map<String, ArrayList<ItemObject>> getObjectsCoordinates() {
        return objectsCoordinates;
    }

    public static void addObjectCoordinate(ItemObject itemObject) {
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

    static void generateFieldObjects(int positionX, int positionY) {
        GameInitializer.initializedClasses.forEach(aClass -> {
            ObjectBasicProperties annotation = aClass.getAnnotation(ObjectBasicProperties.class);
            int randomMaxCount = (int) (Math.random() * annotation.maxCount());
            for (int i = 0; i < randomMaxCount; i++) {
                try {
                    Constructor<?> constructor = aClass.getConstructor(int.class, int.class);
                    constructor.setAccessible(true);
                    ItemObject newItemObject = (ItemObject) constructor.newInstance(positionX, positionY);
                    addObjectCoordinate(newItemObject);
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                         IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Координаты X"+ positionX+"Y"+positionY+" создано " + randomMaxCount + " экземпляров класса " + annotation.printName());
        });
    }
}

