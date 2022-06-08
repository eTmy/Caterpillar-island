package main.java.com.eTmy.caterpillarIsland;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Survival {
    private static Survival instance;

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

    @JsonProperty("survival")
    private List<HashMap<String, HashMap<String, Double>>> survivalList;

    public Double getEatChance(String attackingClassName, String defensiveClassName) {
        Optional<HashMap<String, HashMap<String, Double>>> eatableAnimals = survivalList.stream()
                .filter(stringMapMap -> stringMapMap.containsKey(attackingClassName)).findAny();

        return eatableAnimals.map(stringHashMapHashMap -> stringHashMapHashMap
                .get(attackingClassName)
                .get(defensiveClassName))
                .orElse(null);

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
