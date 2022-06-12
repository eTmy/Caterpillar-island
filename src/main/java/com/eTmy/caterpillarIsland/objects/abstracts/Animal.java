package main.java.com.eTmy.caterpillarIsland.objects.abstracts;

import java.util.Map;

public abstract class Animal extends ItemObject {
    long weight;
    long speed;
    long kgSatisfyHunger;
    boolean dailyActivityCompleted;


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
