package main.java.com.eTmy.caterpillarIsland.objects.plants;

import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Plant;

public class Corn extends Plant {
    public Corn(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF3D";
    }
}
