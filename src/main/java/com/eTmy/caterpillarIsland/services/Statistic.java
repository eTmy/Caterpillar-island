package main.java.com.eTmy.caterpillarIsland.services;

import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Animal;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Plant;

public class Statistic {
    private static final String DEATH_MESSAGE = " objects were eaten";
    private static final String DEATH_HUNGRY_MESSAGE = " animals died of hunger";
    private static final String REPRODUCE_MESSAGE = " animals were born";
    private static final String TOTAL_ANIMAL_COUNT_MESSAGE = "Animal population: ";
    private static final String TOTAL_PLANT_COUNT_MESSAGE = "Plant population: ";

    private int currentDay = 0;
    private int deathsPerDay = 0;
    private int deathsPerDayFromHungry = 0;
    private int reproducePerDay = 0;

    public int getReproducePerDay() {
        return reproducePerDay;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public int getDeathsPerDay() {
        return deathsPerDay;
    }

    public int getDeathsPerDayFromHungry() {
        return deathsPerDayFromHungry;
    }

    public void resetDayStatistic() {
        deathsPerDay = 0;
        reproducePerDay = 0;
        deathsPerDayFromHungry = 0;
    }

    public void plusDeath() {
        deathsPerDay++;
    }

    public void plusDeathFromHungry() {
        deathsPerDayFromHungry++;
    }

    public void plusReproduce() {
        reproducePerDay++;
    }

    public void printStatistic() {
        System.out.println(GameInitializer.gameSettings.getDelimiterMessage());
        System.out.println("Day: " + getCurrentDay());
        System.out.println(getDeathsPerDay() + DEATH_MESSAGE);
        System.out.println(getDeathsPerDayFromHungry() + DEATH_HUNGRY_MESSAGE);
        System.out.println(getReproducePerDay() + REPRODUCE_MESSAGE);
        System.out.println(TOTAL_ANIMAL_COUNT_MESSAGE + GameObjects.getCreatedObjectsCount(Animal.class));
        System.out.println(TOTAL_PLANT_COUNT_MESSAGE + GameObjects.getCreatedObjectsCount(Plant.class));
    }
}
