package main.java.com.eTmy.caterpillarIsland.objects.abstracts;

import main.java.com.eTmy.caterpillarIsland.WorldMap;
import main.java.com.eTmy.caterpillarIsland.services.GameHandler;

public abstract class Animal extends ItemObject {
    private long weight;
    private int speed = 0;
    private long kgSatisfyHunger;
    private boolean dailyActivityCompleted;

    protected Animal(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isDailyActivityCompleted() {
        return dailyActivityCompleted;
    }

    public void setDailyActivityCompleted() {
        this.dailyActivityCompleted = true;
    }

    public void eat() {
    }

    public void move() {
        int posX = getPositionX();
        int posY = getPositionY();

        while (getPositionX() == posX && getPositionY() == posY) {
            int movesCount = getSpeed();
            posX = GameHandler.getRandomCoordinatePosition(posX, movesCount, 0, WorldMap.MAP_WIDTH);
            movesCount -= Math.abs(getPositionX() - posX);
            if (movesCount > 0) {
                posY = GameHandler.getRandomCoordinatePosition(posY, movesCount, 0, WorldMap.MAP_HEIGHT);
            }
        }

        setPosition(posX, posY);
    }

    public void reproduce() {
    }


}
