package main.java.com.eTmy.caterpillarIsland.objects.abstracts;

import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
import main.java.com.eTmy.caterpillarIsland.services.GameHandler;
import main.java.com.eTmy.caterpillarIsland.services.GameInitializer;

public abstract class Animal extends ItemObject {
    private double maxHungryPoints = 0;
    private double hungryPoints = 0;
    private boolean reproduceReady;

    protected Animal(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public void eat(double weight) {
        hungryPoints += Math.min(weight, maxHungryPoints);
    }

    public void setMaxHungryPoints(double maxHungryPoints) {
        this.maxHungryPoints = maxHungryPoints;
    }

    public double getMaxHungryPoints() {
        return maxHungryPoints;
    }

    public boolean isReproduceReady() {
        return reproduceReady;
    }

    public void calculateDailySatiety() {
        hungryPoints = ((hungryPoints - (maxHungryPoints / 4)) < 0) ? 0 : hungryPoints - (maxHungryPoints / 4);
    }

    public void calculateReproduce() {
        reproduceReady = getHungryPoints() > getMaxHungryPoints() / 2;
    }

    public double getHungryPoints() {
        return hungryPoints;
    }

    public void setHungryPoints(double hungryPoints) {
        this.hungryPoints = hungryPoints;
    }

    public void reproduce() {
        GameObjects.createItemObject(this.getClass(), getPositionX(), getPositionY());
        GameInitializer.statistic.plusReproduce();
    }

    public boolean hunt() {
        if (GameHandler.canEatOnCurrentField(this)) {
            ItemObject defensiveObject = GameObjects.getRandomEatableObjectOnField(this);
            boolean huntResult = GameHandler.tryEatObject(this, defensiveObject);
            if (huntResult) {
                this.eat(defensiveObject.getWeight());
                defensiveObject.setDead(true);
            }
            return true;
        }
        return false;
    }

}
