package main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores;

import main.java.com.eTmy.caterpillarIsland.objects.abstracts.CarnivoreAnimal;

public class Fox extends CarnivoreAnimal {
    public Fox(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}
