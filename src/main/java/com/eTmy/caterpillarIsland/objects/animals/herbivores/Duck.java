package main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.HerbivoreAnimal;

@ObjectBasicProperties(maxCount = 200, printName = "Утка")
public class Duck extends HerbivoreAnimal {
    public Duck(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(4);
        setWeight(1);
        setMaxHungryPoints(0.15);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD86";
    }
}
