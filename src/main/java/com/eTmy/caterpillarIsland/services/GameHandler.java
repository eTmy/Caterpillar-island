package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.Survival;
import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Animal;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;

import java.util.*;

public class GameHandler {
    public static void makeDailyActivity(Animal animal) {
        //calculateStats(animal)
        hunts(animal);
        animal.setDailyActivityCompleted();

        //replace with log statistic
        System.out.println(animal.toString() + " has finished daily activity");
    }

    private static void hunts(Animal animal) {
        if (canEatOnCurrentField(animal)) {
            ItemObject defensiveObject = GameObjects.getRandomEatableObjectOnField(animal);
            boolean huntResult = tryEatObject(animal, defensiveObject);
            if (huntResult) {
                //calculateStats attacking and defensive objects
            }
            //replace with log statistic
            System.out.println(animal.toString() + " attacking -> " + defensiveObject.toString() + " | result " + huntResult);
            return;
        }

        if (animal.getSpeed() > 0) {
            System.out.print(animal.toString() + " move from " + animal.getPositionKey() + " ");
            animal.move();
            //replace with log statistic
            System.out.println("to " + animal.getPositionKey() + " max speed " + animal.getSpeed());
        }

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
