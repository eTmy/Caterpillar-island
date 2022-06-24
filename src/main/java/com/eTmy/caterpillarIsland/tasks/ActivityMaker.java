package main.java.com.eTmy.caterpillarIsland.tasks;

import main.java.com.eTmy.caterpillarIsland.services.GameInitializer;

import java.util.concurrent.Phaser;

public class ActivityMaker implements  Runnable {
    Phaser phaser;

    public ActivityMaker(Phaser p) {
        this.phaser = p;
        phaser.register();
    }

    public void run() {
        GameInitializer.makeAnimalActivity();
        phaser.arriveAndDeregister();
    }
}
