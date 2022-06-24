package main.java.com.eTmy.caterpillarIsland.tasks;

import main.java.com.eTmy.caterpillarIsland.services.GameInitializer;

import java.util.concurrent.Phaser;

public class StatisticPrinter implements Runnable {
    Phaser phaser;

    public StatisticPrinter(Phaser p) {
        this.phaser = p;
        phaser.register();
    }

    public void run() {
        GameInitializer.statistic.printStatistic();
        phaser.arriveAndDeregister();
    }

}
