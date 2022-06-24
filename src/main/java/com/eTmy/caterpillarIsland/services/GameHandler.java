package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Animal;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;

import java.util.*;

public class GameHandler {
    public static void makeDailyActivity(Animal animal) {
        calculateAnimalDailyStats(animal);

        if (animal.isDead()) {
            return;
        }

        if (canReproduce(animal)) {
            animal.reproduce();
        } else {
            tryHunt(animal);
        }

        animal.setDailyActivityCompleted(true);
    }

    public static void calculateAnimalDailyStats(Animal animal) {
        animal.calculateDailySatiety();
        animal.calculateReproduce();

        if (animal.getHungryPoints() <= 0) {
            animal.setHP(animal.getHP() - 25);
        }

        if (animal.getHP() <= 0) {
            animal.setDead(true);
            GameInitializer.statistic.plusDeathFromHungry();
        }
    }

    private static void tryHunt(Animal animal) {
       if (animal.hunt()) {
           return;
       }

       animal.move();

        if (animal.getSpeed() > 0) {
            int tryMoveCount = 3;
            while (tryMoveCount != 0) {
                String newPositionKey = getNewPositionKey(animal);
                if (!newPositionKey.equals(animal.getPositionKey())) {
                    animal.setMovePositionKey(newPositionKey);
                    break;
                }
                tryMoveCount--;
            }
        }

    }
    public static boolean canReproduce(Animal animal) {
        return animal.isReproduceReady()
                && GameObjects.canCreateObjectOnField(animal.getPositionKey(), animal.getClass())
                && GameObjects.getRandomAnimalForSexOnField(animal.getPositionKey(), animal.getClass().getSimpleName()) != null;
    }

    public static String getNewPositionKey(ItemObject itemObject) {
        int posX = itemObject.getPositionX();
        int posY = itemObject.getPositionY();
        int movesCount = itemObject.getSpeed();

        posX = getRandomCoordinatePosition(posX, movesCount, 0, GameInitializer.gameSettings.getMapWidth() - 1);
        movesCount -= Math.abs(itemObject.getPositionX() - posX);
        if (movesCount > 0) {
            posY = getRandomCoordinatePosition(posY, movesCount, 0, GameInitializer.gameSettings.getMapHeight() - 1);
        }

        return "x" + posX + "y" + posY;
    }

    public static int getRandomCoordinatePosition(int currentPosition, int movesCount, int minLimit, int maxLimit) {
        int minPosition = Math.max(currentPosition - movesCount, minLimit);
        int maxPosition = Math.min(currentPosition + movesCount, maxLimit);
        maxPosition -= minPosition;
        return (int) (Math.random() * ++maxPosition) + minPosition;
    }

    public static boolean canEatOnCurrentField(Animal animal) {
        List<ItemObject> eatableObjectsOnField = GameObjects.getEatableObjectsOnField(animal);
        return eatableObjectsOnField != null && eatableObjectsOnField.size() != 0;
    }

    public static boolean tryEatObject(Animal attackingAnimal, ItemObject defensiveObject) {
        Double eatChance = Survival.getInstance()
                .getEatChance(attackingAnimal.getClass().getSimpleName(), defensiveObject.getClass().getSimpleName());
        return eatChance != 0.0 && throwDice(eatChance);
    }

    private static boolean throwDice(double chance) {
        return (Math.random() * 100) < chance;
    }
}
