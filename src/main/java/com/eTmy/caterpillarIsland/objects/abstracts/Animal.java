package main.java.com.eTmy.caterpillarIsland.objects.abstracts;

public abstract class Animal extends ItemObject {
    long weight;
    long speed;
    long kgSatisfyHunger;
    protected Animal(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public void eat() {
    }

    public void choseMoveDirection() {
    }

    public void move() {

    }

    public void reproduce() {
    }


}
