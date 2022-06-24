package main.java.com.eTmy.caterpillarIsland.objects.animals.carnivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.CarnivoreAnimal;

@ObjectBasicProperties(maxCount = 30, printName = "Волк")
public class Wolf extends CarnivoreAnimal {
    public Wolf(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(3);
        setWeight(50);
        setMaxHungryPoints(8);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}
