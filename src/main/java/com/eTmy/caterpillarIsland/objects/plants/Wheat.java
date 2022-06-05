package main.java.com.eTmy.caterpillarIsland.objects.plants;

import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Plant;

public class Wheat extends Plant {
    public Wheat(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF3E";
    }
}
