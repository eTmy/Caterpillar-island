package main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.HerbivoreAnimal;

@ObjectBasicProperties(maxCount = 20, printName = "Лошадь")
public class Horse extends HerbivoreAnimal {
    public Horse(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(4);
        setWeight(400);
        setMaxHungryPoints(60);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC0E";
    }
}
