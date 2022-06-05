package main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores;

import main.java.com.eTmy.caterpillarIsland.objects.abstracts.HerbivoreAnimal;

public class Duck extends HerbivoreAnimal {
    public Duck(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD86";
    }
}
