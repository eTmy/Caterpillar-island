package main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.HerbivoreAnimal;

@ObjectBasicProperties(maxCount = 150, printName = "Кролик")
public class Rabbit extends HerbivoreAnimal {
    public Rabbit(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(2);
        setWeight(2);
        setMaxHungryPoints(0.45);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }
}
