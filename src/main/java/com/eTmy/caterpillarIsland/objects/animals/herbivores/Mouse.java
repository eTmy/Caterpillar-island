package main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.HerbivoreAnimal;

@ObjectBasicProperties(maxCount = 500, printName = "Мышь")
public class Mouse extends HerbivoreAnimal {
    public Mouse(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(1);
        setWeight(0.05);
        setMaxHungryPoints(0.01);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC01";
    }
}
