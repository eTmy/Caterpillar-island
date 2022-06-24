package main.java.com.eTmy.caterpillarIsland.db;

import main.java.com.eTmy.caterpillarIsland.services.Survival;
import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Animal;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;
import main.java.com.eTmy.caterpillarIsland.services.GameInitializer;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameObjects {
    private static Map<String, CopyOnWriteArrayList<ItemObject>> createdObjects = new ConcurrentHashMap<>();

    public static Map<String, CopyOnWriteArrayList<ItemObject>> getGameObjects() {
        return createdObjects;
    }

    public static void generateGameFields(List<Class<?>> classes) {
        for (int x = 0; x < GameInitializer.gameSettings.getMapWidth(); x++) {
            for (int y = 0; y < GameInitializer.gameSettings.getMapHeight(); y++) {
                for (Class<?> aClass : classes) {
                    generateItemObjectsOnField(aClass, x, y);
                }
            }
        }
    }

    public static void generateItemObjectsOnField(@NotNull Class<?> aClass, int positionX, int positionY) {
        ObjectBasicProperties annotation = aClass.getAnnotation(ObjectBasicProperties.class);
        int randomMaxCount = (int) (Math.random() * annotation.maxCount());
        int createdCount = getCreatedObjectsCountOnField("x" + positionX + "y" + positionY, aClass);
        for (int i = createdCount; i < randomMaxCount; i++) {
            createItemObject(aClass, positionX, positionY);
        }
    }

    private static void removeObject(ItemObject itemObject) {
        createdObjects.get(itemObject.getPositionKey()).remove(itemObject);
    }

    public static void updateCreatedObjects() {
        List<ItemObject> allCreatedObjects = getListAllCreatedObjects();
        allCreatedObjects.forEach(itemObject -> {
            if (itemObject.isDead()) {
                removeObject(itemObject);
                return;
            }
            if (!itemObject.getPositionKey().equals(itemObject.getMovePositionKey())) {
                removeObject(itemObject);
                itemObject.move();
                addToCreatedObjects(itemObject);
            }
        });
    }

    public static List<ItemObject> getListAllCreatedObjects() {
        List<ItemObject> itemObjects = new ArrayList<>();
        GameObjects.getGameObjects().forEach((k, v) -> itemObjects.addAll(v));

        return itemObjects;
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
        CopyOnWriteArrayList<ItemObject> mapValue = createdObjects.get(itemObject.getPositionKey());
        if (mapValue == null) {
            CopyOnWriteArrayList<ItemObject> objects = new CopyOnWriteArrayList<>();
            objects.add(itemObject);
            createdObjects.put(itemObject.getPositionKey(), objects);
        } else {
            mapValue.add(itemObject);
            createdObjects.put(itemObject.getPositionKey(), mapValue);
        }
    }

    public static ArrayList<ItemObject> getObjectsOnField(String positionKey) {
        if (createdObjects.get(positionKey) == null) {
            return null;
        }
        return new ArrayList<>(createdObjects.get(positionKey));
    }

    public static ItemObject getRandomAnimalForSexOnField(String positionKey, String aClass) {
        return createdObjects.get(positionKey).stream()
                .filter(animal -> animal.getClass().getSimpleName().equals(aClass))
                .map(itemObject -> (Animal) itemObject)
                .filter(animal -> !animal.isDead() && animal.isReproduceReady())
                .findAny()
                .orElse(null);
    }

    public static List<ItemObject> getEatableObjectsOnField(Animal animal) {
        List<String> eatableObjects = Survival.getInstance().getEatableObjects(animal.getClass().getSimpleName());
        List<ItemObject> objectsOnField = getObjectsOnField(animal.getMovePositionKey());

        if (eatableObjects == null || objectsOnField == null) {
            return null;
        }

        objectsOnField.removeIf(itemObject -> !eatableObjects.contains(itemObject.getClass().getSimpleName())
                || itemObject.isDead()
                || itemObject.hasMoved());

        return objectsOnField;
    }

    public static ItemObject getRandomEatableObjectOnField(Animal animal) {
        List<ItemObject> eatableObjectsOnField = getEatableObjectsOnField(animal);

        Random random = new Random();

        return eatableObjectsOnField.get(random.nextInt(eatableObjectsOnField.size()));
    }

    public static boolean canCreateObjectOnField(String positionKey, Class<?> aClass) {
        ObjectBasicProperties annotation = aClass.getAnnotation(ObjectBasicProperties.class);
        long countCreatedObjects = getObjectsOnField(positionKey).stream()
                .filter(itemObject -> itemObject.getClass().getSimpleName().equals(aClass.getSimpleName()))
                .count();
        return countCreatedObjects < annotation.maxCount();
    }

    public static long getCreatedObjectsCount(Class<?> aClass) {
        return getListAllCreatedObjects().stream()
                .filter(itemObject -> aClass.isAssignableFrom(itemObject.getClass()))
                .count();
    }

    public static int getCreatedObjectsCountOnField(String positionKey, Class<?> aClass) {
        List<ItemObject> itemObjects = getObjectsOnField(positionKey);
        if (itemObjects == null) {
            return 0;
        }
        return (int) itemObjects.stream()
                .filter(itemObject -> itemObject.getClass().getSimpleName().equals(aClass.getSimpleName()))
                .count();
    }
}
