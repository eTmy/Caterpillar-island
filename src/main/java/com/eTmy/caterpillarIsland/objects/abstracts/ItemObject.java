package main.java.com.eTmy.caterpillarIsland.objects.abstracts;

public abstract class ItemObject {
    private int positionX;
    private int positionY;
    private String positionKey;

    private int HP;

    protected ItemObject(int positionX, int positionY) {
        setPosition(positionX, positionY);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPosition(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        positionKey = "x" + positionX + "y" + positionY;
    }

    public String getPositionKey() {
        return positionKey;
    }



}
