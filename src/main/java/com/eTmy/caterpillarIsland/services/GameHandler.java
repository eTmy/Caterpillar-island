package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.Survival;
import main.java.com.eTmy.caterpillarIsland.WorldMap;
import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Animal;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;
import main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores.Caterpillar;

import java.util.*;

public class GameHandler {
    public static void makeDailyActivity(Animal animal) {
        calculateAnimalDailyStats(animal);

        if (animal.isDead()) {
            return;
        }

        if (animal.isReproduceReady()
                && GameObjects.canCreateObjectOnField(animal.getPositionKey(), animal.getClass())
                && GameObjects.getRandomAnimalForSexOnField(animal.getPositionKey(), animal.getClass().getSimpleName()) != null
        ) {
            animal.reproduce();
            System.out.println(animal + " makes a baby");
        } else {
            hunt(animal);
        }
        animal.setDailyActivityCompleted(true);
    }

    public static void calculateAnimalDailyStats(Animal animal) {
        animal.calculateDailySatiety();
        animal.calculateReproduce();

        if (animal.getCurrentSatietyPoints() <= 0) {
            animal.setHP(animal.getHP() - 25);
            // System.out.println(animal + " reduced by 15 health points");
        }

        if (animal.getHP() <= 0) {
            animal.setDead(true);
            System.out.println(animal + " starved to death");
        }
    }

    private static void hunt(Animal animal) {
        if (canEatOnCurrentField(animal)) {
            //охотится на максимально сытый обьект
            ItemObject defensiveObject = GameObjects.getRandomEatableObjectOnField(animal);
            boolean huntResult = tryEatObject(animal, defensiveObject);
            if (huntResult) {
                animal.eat(defensiveObject.getWeight());
                defensiveObject.setDead(true);
            }
            //replace with log statistic
            if (!(animal instanceof Caterpillar)) {
                System.out.println(animal + " attacking -> " + defensiveObject + " | result " + huntResult
                        + " | Satiety: max " + String.format("%.2f", animal.getMaxSatietyPoints())
                        + "  current " + String.format("%.2f", animal.getCurrentSatietyPoints()));
            }
            return;
        }

        if (animal.getSpeed() > 0) {
            System.out.print(animal + " moves from " + animal.getPositionKey() + " ");

            int tryMoveCount = 3;

            while (tryMoveCount != 0) {
                String newPositionKey = getNewPositionKey(animal);
                if (!newPositionKey.equals(animal.getPositionKey())) {
                    animal.move(newPositionKey);
                    break;
                }
                tryMoveCount--;
            }

            //replace with log statistic
            System.out.println("to " + animal.getPositionKey() + " max speed " + animal.getSpeed());
        }

    }

    public static String getNewPositionKey(ItemObject itemObject) {
        int posX = itemObject.getPositionX();
        int posY = itemObject.getPositionY();

        int movesCount = itemObject.getSpeed();
        posX = getRandomCoordinatePosition(posX, movesCount, 0, WorldMap.MAP_WIDTH);
        movesCount -= Math.abs(itemObject.getPositionX() - posX);
        if (movesCount > 0) {
            posY = getRandomCoordinatePosition(posY, movesCount, 0, WorldMap.MAP_HEIGHT);
        }

        return "x" + posX + "y" + posY;
    }

    public static int getRandomCoordinatePosition(int currentPosition, int movesCount, int minLimit, int maxLimit) {
        int minPosition = Math.max(currentPosition - movesCount, minLimit);
        int maxPosition = Math.min(currentPosition + movesCount, maxLimit);
        maxPosition -= minPosition;
        return (int) (Math.random() * ++maxPosition) + minPosition;
    }

    private static boolean canEatOnCurrentField(Animal animal) {
        List<ItemObject> eatableObjectsOnField = GameObjects.getEatableObjectsOnField(animal);
        return eatableObjectsOnField != null && eatableObjectsOnField.size() != 0;
    }

    private static boolean tryEatObject(Animal attackingAnimal, ItemObject defensiveObject) {
        Double eatChance = Survival.getInstance()
                .getEatChance(attackingAnimal.getClass().getSimpleName(), defensiveObject.getClass().getSimpleName());
        return eatChance != 0.0 && throwDice(eatChance);
    }

    private static boolean throwDice(double chance) {
        return (Math.random() * 100) < chance;
    }
}
