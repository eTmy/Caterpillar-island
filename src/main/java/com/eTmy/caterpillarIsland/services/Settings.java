package main.java.com.eTmy.caterpillarIsland.services;

public class Settings {
    private int maxDays;
    private int mapWidth;
    private int mapHeight;


    private String delimiterMessage = "****************************************";

    public Settings() {
        this.maxDays = 50;
        this.mapWidth = 5;
        this.mapHeight = 5;
    }

    public Settings(int MAX_DAYS, int mapWidth, int mapHeight) {
        this.maxDays = MAX_DAYS;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }

    public String getDelimiterMessage() {
        return delimiterMessage;
    }

    public void setDelimiterMessage(String delimiterMessage) {
        this.delimiterMessage = delimiterMessage;
    }
}
