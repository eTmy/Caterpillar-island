package main.java.com.eTmy.caterpillarIsland.objects.abstracts;

import main.java.com.eTmy.caterpillarIsland.services.GameInitializer;

public abstract class ItemObject {
    private int positionX;
    private int positionY;
    private String positionKey;
    private String movePositionKey;
    private int HP = 100;
    private double weight;
    private int speed = 0;
    private boolean isDead = false;

    private boolean dailyActivityCompleted;

    protected ItemObject(int positionX, int positionY) {
        setPosition(positionX, positionY);
        setMovePositionKey(positionKey);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPosition(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionKey = "x" + positionX + "y" + positionY;
    }

    public void setPosition(String positionKey) {
        this.positionX = Integer.parseInt(String.valueOf(positionKey.charAt(1)));
        this.positionY = Integer.parseInt(String.valueOf(positionKey.charAt(3)));
        this.positionKey = positionKey;
    }

    public String getPositionKey() {
        return positionKey;
    }

    public String getMovePositionKey() {
        return movePositionKey;
    }

    public void setMovePositionKey(String movePositionKey) {
        this.movePositionKey = movePositionKey;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void move() {
        setPosition(getMovePositionKey());
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
        GameInitializer.statistic.plusDeath();
    }

    public boolean hasMoved() {
        return positionKey.equals(movePositionKey);
    }

    public boolean isDailyActivityCompleted() {
        return dailyActivityCompleted;
    }

    public void setDailyActivityCompleted(boolean dailyActivityCompleted) {
        this.dailyActivityCompleted = dailyActivityCompleted;
    }
}
