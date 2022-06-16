package main.java.com.eTmy.caterpillarIsland.objects.plants;

import main.java.com.eTmy.caterpillarIsland.annotations.animals.ObjectBasicProperties;
import main.java.com.eTmy.caterpillarIsland.objects.abstracts.Plant;

@ObjectBasicProperties(maxCount = 100, printName = "Кукуруза")
public class Corn extends Plant {
    public Corn(int positionX, int positionY) {
        super(positionX, positionY);
        setWeight(1);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF3D";
    }
}
