// File: invaders/strategy/EasyDifficultyStrategy.java
package invaders.strategy;

import invaders.engine.GameEngine;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Scanner;

public class EasyDifficultyStrategy implements DifficultyStrategy {
    @Override
    public void initialize(GameEngine engine) {
        engine.getGameObjects().clear();
        engine.getRenderables().clear();

        try {
            Scanner scanner = new Scanner(Paths.get("src/main/resources/config_easy.json")).useDelimiter("\\Z");
            String content = scanner.next();
            // Here you can parse the content string to get the required data from the JSON
            // For example, if you need a value associated with a key "enemySpeed", you can do something like:
            // String enemySpeed = content.split("\"enemySpeed\":")[1].split(",")[0].trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Similarly, create MediumDifficultyStrategy and HardDifficultyStrategy with appropriate paths.
