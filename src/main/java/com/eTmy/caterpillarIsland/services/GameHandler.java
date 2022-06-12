package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.Survival;
import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Animal;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.ItemObject;

import java.util.*;

public class GameHandler {

    public static void makeDailyActivity(Animal animal) {
        //расчитать характеристики на начало хода
        if (canEatOnCurrentField(animal)) {
            ItemObject defensiveObject = GameObjects.getRandomEatableObjectOnField(animal);
            System.out.print(animal.toString() + " attacking -> " + defensiveObject.toString()+" | ");
            boolean result = tryEat(animal, defensiveObject);
            System.out.println(" result " + result);
        }
    }

    public static boolean canEatOnCurrentField(Animal animal) {
        List<ItemObject> eatableObjectsOnField = GameObjects.getEatableObjectsOnField(animal);
        return eatableObjectsOnField != null && eatableObjectsOnField.size() != 0;
    }

    public static boolean tryEat(Animal attackingAnimal, ItemObject defensiveObject) {
        Double eatChance = Survival.getInstance()
                .getEatChance(attackingAnimal.getClass().getSimpleName(), defensiveObject.getClass().getSimpleName());
        System.out.print("eat chance = "+eatChance+" ");
        return eatChance != 0.0 && throwDice(eatChance);
    }

    public static boolean throwDice(double chance) {
        double randomNumber = (Math.random() * 100);
                System.out.print("| dice result = "+randomNumber+" | ");
        return randomNumber < chance;
                //return (Math.random() * 100) < chance;
    }
}
