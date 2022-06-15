package main.java.com.eTmy.caterpillarIsland.objects.abstracts;

public abstract class ItemObject {
    private int positionX;
    private int positionY;
    private String positionKey;
    private int HP = 100;
    private long weight;
    private int speed = 0;
    boolean isDead = false;

    private boolean dailyActivityCompleted;

    protected ItemObject(int positionX, int positionY) {
        setPosition(positionX, positionY);
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
        this.positionX = positionKey.toCharArray()[1];
        this.positionY = positionKey.toCharArray()[3];
        this.positionKey = positionKey;
    }

    public String getPositionKey() {
        return positionKey;
    }

    public long getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void move(int posX, int posY) {
        setPosition(posX, posY);
    }

    public void move(String positionKey) {
        setPosition(positionKey);
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
    }

    public boolean isDailyActivityCompleted() {
        return dailyActivityCompleted;
    }

    public void setDailyActivityCompleted(boolean dailyActivityCompleted) {
        this.dailyActivityCompleted = dailyActivityCompleted;
    }
}
