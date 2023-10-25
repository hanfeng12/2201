package invaders.strategy;

import invaders.ConfigReader;
import invaders.builder.BunkerBuilder;
import invaders.builder.Director;
import invaders.builder.EnemyBuilder;
import invaders.gameobject.Bunker;
import invaders.gameobject.Enemy;
import invaders.engine.GameEngine;
import org.json.simple.JSONObject;

public class HardDifficultyStrategy implements DifficultyStrategy {

    @Override
    public void initialize(GameEngine gameEngine) {
        // Clear current gameObjects and renderables lists
        gameEngine.getGameObjects().clear();
        gameEngine.getRenderables().clear();

        // Initialize Player
        gameEngine.getRenderables().add(gameEngine.getPlayer());

        Director director = new Director();

        // Initialize Bunkers
        BunkerBuilder bunkerBuilder = new BunkerBuilder();
        for (Object eachBunkerInfo : ConfigReader.getBunkersInfo()) {
            Bunker bunker = director.constructBunker(bunkerBuilder, (JSONObject) eachBunkerInfo);
            gameEngine.getGameObjects().add(bunker);
            gameEngine.getRenderables().add(bunker);
        }

        // Initialize Enemies for Hard Difficulty
        EnemyBuilder enemyBuilder = new EnemyBuilder();
        for (Object eachEnemyInfo : ConfigReader.getEnemiesInfo()) {
            // Assuming differentiation is done within constructEnemy or JSON config
            Enemy enemy = director.constructEnemy(gameEngine, enemyBuilder, (JSONObject) eachEnemyInfo);
            gameEngine.getGameObjects().add(enemy);
            gameEngine.getRenderables().add(enemy);
        }
    }
}
