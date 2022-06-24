package main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.HerbivoreAnimal;

@ObjectBasicProperties(maxCount = 1000, printName = "Гусеница")
public class Caterpillar extends HerbivoreAnimal {


    public Caterpillar(int positionX, int positionY) {
        super(positionX, positionY);
        setWeight(0.01);
        setMaxHungryPoints(0.01);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC1B";
    }
}
