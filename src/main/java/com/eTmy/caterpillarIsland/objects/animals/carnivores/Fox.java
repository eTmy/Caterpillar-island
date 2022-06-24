package main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.CarnivoreAnimal;

@ObjectBasicProperties(maxCount = 30, printName = "Лиса")
public class Fox extends CarnivoreAnimal {
    public Fox(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(2);
        setWeight(8);
        setMaxHungryPoints(2);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}
