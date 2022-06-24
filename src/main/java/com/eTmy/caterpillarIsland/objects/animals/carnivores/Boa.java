package main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.CarnivoreAnimal;

@ObjectBasicProperties(maxCount = 30, printName = "Удав")
public class Boa extends CarnivoreAnimal {
    public Boa(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(1);
        setWeight(50);
        setMaxHungryPoints(3);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC0D";
    }
}
