package main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.HerbivoreAnimal;

@ObjectBasicProperties(maxCount = 20, printName = "Олень")
public class Deer extends HerbivoreAnimal {
    public Deer(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(4);
        setWeight(300);
        setMaxHungryPoints(50);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8C";
    }
}
