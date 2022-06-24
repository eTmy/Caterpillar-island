package main.java.com.eTmy.caterpillarIsland.tasks;

import main.java.com.eTmy.caterpillarIsland.services.GameInitializer;

import java.util.concurrent.Phaser;

public class ObjectGenerator implements Runnable {
    Phaser phaser;
    Class<?> aClass;

    public ObjectGenerator(Phaser p, Class<?> aClass) {
        this.phaser = p;
        this.aClass = aClass;
        phaser.register();
    }

    public void run() {
        GameInitializer.generateObjects(aClass);
        phaser.arriveAndDeregister();
    }

}
