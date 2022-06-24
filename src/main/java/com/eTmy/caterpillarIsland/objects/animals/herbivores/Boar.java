package main.java.com.eTmy.caterpillarIsland.objects.animals.herbivores;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.HerbivoreAnimal;

@ObjectBasicProperties(maxCount = 50, printName = "Кабан")
public class Boar extends HerbivoreAnimal {
    public Boar(int positionX, int positionY) {
        super(positionX, positionY);
        setSpeed(2);
        setWeight(400);
        setMaxHungryPoints(50);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC17";
    }
}
