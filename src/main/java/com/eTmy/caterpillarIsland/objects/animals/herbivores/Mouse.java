package main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores;

import main.java.com.eTmy.caterpillarIsland.objects.abstracts.HerbivoreAnimal;

public class Mouse extends HerbivoreAnimal {
    public Mouse(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC01";
    }
}
