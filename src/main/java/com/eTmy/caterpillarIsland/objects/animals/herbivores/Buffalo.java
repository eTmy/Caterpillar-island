package main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.HerbivoreAnimal;

@ObjectBasicProperties(maxCount = 10, printName = "Буйвол")
public class Buffalo extends HerbivoreAnimal {
    public Buffalo(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(3);
        setWeight(700);
        setMaxHungryPoints(100);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC03";
    }
}
