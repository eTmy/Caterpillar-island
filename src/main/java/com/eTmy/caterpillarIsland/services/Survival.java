package main.java.com.eTmy.caterpillarIsland.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Survival {
    private static Survival instance;

    @JsonProperty("survival")
    private List<HashMap<String, HashMap<String, Double>>> survivalList;

    private Survival() {

    }

    public static Survival getInstance() {
        if (instance == null) {
            instance = new Survival();
            initializeSurvivalList();
        }
        return instance;
    }

    public List<HashMap<String, HashMap<String, Double>>> getSurvivalList() {
        return survivalList;
    }

    public Double getEatChance(String attackingClassName, String defensiveClassName) {
        HashMap<String, HashMap<String, Double>> eatableObjects = survivalList.stream().filter(stringHashMapHashMap -> stringHashMapHashMap.containsKey(attackingClassName))
                .findAny()
                .orElse(null);

        if (eatableObjects == null) {
            return 0.0;
        }

        Double chance = eatableObjects.get(attackingClassName).get(defensiveClassName);
        return (chance == null) ? 0.0 : chance;
    }

    public ArrayList<String> getEatableObjects(String className) {
        HashMap<String, HashMap<String, Double>> eatableObjects = survivalList.stream()
                .filter(stringMapMap -> stringMapMap.containsKey(className))
                .findAny()
                .orElse(null);

        if (eatableObjects == null) {
            return null;
        }

        return new ArrayList<>(eatableObjects.get(className).keySet());
    }

    private static void initializeSurvivalList() {
        ObjectMapper mapper = new ObjectMapper();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("survival.yaml").getFile());

        ObjectMapper om = new ObjectMapper(new YAMLFactory());

        try {
            instance = om.readValue(file, Survival.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file" + e.getMessage());
        }

    }
}
