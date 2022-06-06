package main.java.com.eTmy.caterpillarIsland.db;

import main.java.com.eTmy.caterpillarIsland.WorldMap;
import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;
import main.java.com.eTmy.caterpillarIsland.services.GameInitializer;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameObjects {
    private static final Map<String, ArrayList<ItemObject>> createdObjects = new HashMap<>();

    public static Map<String, ArrayList<ItemObject>> getGameObjects() {
        return createdObjects;
    }

    public static void generateGameFields() {
        for (int x = 0; x < WorldMap.MAP_WIDTH; x++) {
            for (int y = 0; y < WorldMap.MAP_HEIGHT; y++) {
                for (Class<?> aClass : GameInitializer.usedGameObjectClasses) {
                    generateItemObjectsOnField(aClass, x, y);
                }
            }
        }
    }

    public static void generateItemObjectsOnField(@NotNull Class<?> aClass, int positionX, int positionY) {
        ObjectBasicProperties annotation = aClass.getAnnotation(ObjectBasicProperties.class);
        int randomMaxCount = (int) (Math.random() * annotation.maxCount());
        for (int i = 0; i < randomMaxCount; i++) {
            createItemObject(aClass, positionX, positionY);
        }
        System.out.println("Координаты X" + positionX + "Y" + positionY + " создано " + randomMaxCount + " экземпляров класса " + annotation.printName());
    }

    public static void createItemObject(@NotNull Class<?> aClass, int positionX, int positionY) {
        try {
            Constructor<?> constructor = aClass.getConstructor(int.class, int.class);
            ItemObject newItemObject = (ItemObject) constructor.newInstance(positionX, positionY);
            addToCreatedObjects(newItemObject);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException("Object creation error: " + e.getMessage());
        }
    }

    public static void addToCreatedObjects(@NotNull ItemObject itemObject) {
        ArrayList<ItemObject> mapValue = createdObjects.get(itemObject.getPositionKey());
        if (mapValue == null) {
            ArrayList<ItemObject> objects = new ArrayList<>();
            objects.add(itemObject);
            createdObjects.put(itemObject.getPositionKey(), objects);
        } else {
            mapValue.add(itemObject);
            createdObjects.put(itemObject.getPositionKey(), mapValue);
        }
    }
}
