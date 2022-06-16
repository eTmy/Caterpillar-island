package main.java.com.eTmy.caterpillarIsland.objects.abstracts;

import main.java.com.eTmy.caterpillarIsland.db.GameObjects;

public abstract class Animal extends ItemObject {
    private double maxSatietyPoints = 0;
    private double currentSatietyPoints = 0;

    private boolean reproduceReady;

    protected Animal(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public void eat(double weight) {
        currentSatietyPoints += Math.min(weight, maxSatietyPoints);
    }

    public void setMaxSatietyPoints(double maxSatietyPoints) {
        this.maxSatietyPoints = maxSatietyPoints;
    }

    public double getMaxSatietyPoints() {
        return maxSatietyPoints;
    }

    public boolean isReproduceReady() {
        return reproduceReady;
    }

    public void calculateDailySatiety() {
        currentSatietyPoints = ((currentSatietyPoints - (maxSatietyPoints / 4)) < 0) ? 0 : currentSatietyPoints - (maxSatietyPoints / 4);
    }

    public void calculateReproduce() {
        reproduceReady = getCurrentSatietyPoints() > getMaxSatietyPoints() / 2;
    }

    public double getCurrentSatietyPoints() {
        return currentSatietyPoints;
    }

    public void setCurrentSatietyPoints(double currentSatietyPoints) {
        this.currentSatietyPoints = currentSatietyPoints;
    }

    public void reproduce() {
        GameObjects.createItemObject(this.getClass(), getPositionX(), getPositionY());
    }


}
