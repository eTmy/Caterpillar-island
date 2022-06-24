package main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.CarnivoreAnimal;

@ObjectBasicProperties(maxCount = 20, printName = "Орел")
public class Eagle extends CarnivoreAnimal {
    public Eagle(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(3);
        setWeight(6);
        setMaxHungryPoints(1);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD85";
    }
}
