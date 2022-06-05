package main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores;

import main.java.com.eTmy.caterpillarIsland.objects.abstracts.CarnivoreAnimal;

public class Bear extends CarnivoreAnimal {
    public Bear(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3B";
    }
}
