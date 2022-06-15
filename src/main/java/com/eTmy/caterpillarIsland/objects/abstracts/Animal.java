package main.java.com.eTmy.caterpillarIsland.objects.abstracts;

import main.java.com.eTmy.caterpillarIsland.WorldMap;
import main.java.com.eTmy.caterpillarIsland.db.GameObjects;
import main.java.com.eTmy.caterpillarIsland.services.GameHandler;

public abstract class Animal extends ItemObject {
    private long maxSatiety = 10;
    private long currentSatiety;

    protected Animal(int positionX, int positionY) {
        super(positionX, positionY);
        this.currentSatiety = maxSatiety;
    }

    public void eat(long weight) {
        currentSatiety += Math.min(weight, maxSatiety);
    }

    public void setMaxSatiety(long maxSatiety) {
        this.maxSatiety = maxSatiety;
    }

    public long getMaxSatiety() {
        return maxSatiety;
    }

    public void calculateDailySatiety() {
        currentSatiety -= maxSatiety / 3;
    }

    public long getCurrentSatiety() {
        return currentSatiety;
    }

    public void setCurrentSatiety(long currentSatiety) {
        this.currentSatiety = currentSatiety;
    }

    public void reproduce(Animal animal) {
        GameObjects.createItemObject(animal.getClass(), getPositionX(), getPositionY());
    }


}
