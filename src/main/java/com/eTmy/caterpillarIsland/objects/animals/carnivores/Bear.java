package main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.CarnivoreAnimal;

@ObjectBasicProperties(maxCount = 5, printName = "Медведь")
public class Bear extends CarnivoreAnimal {
    public Bear(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(2);
        setWeight(500);
        setMaxHungryPoints(80);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3B";
    }
}
