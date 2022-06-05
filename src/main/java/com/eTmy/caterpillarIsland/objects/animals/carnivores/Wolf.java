package main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores;

import main.java.com.eTmy.caterpillarIsland.objects.abstracts.CarnivoreAnimal;

public class Wolf extends CarnivoreAnimal {
    public Wolf(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}
