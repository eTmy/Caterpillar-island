package main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.HerbivoreAnimal;

@ObjectBasicProperties(maxCount = 140, printName = "Коза")
public class Goat extends HerbivoreAnimal {
    public Goat(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(3);
        setWeight(60);
        setMaxHungryPoints(10);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC10";
    }
}
