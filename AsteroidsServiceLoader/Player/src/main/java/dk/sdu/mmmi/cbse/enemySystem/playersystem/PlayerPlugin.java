package dk.sdu.mmmi.cbse.enemySystem.playersystem;

import dk.sdu.mmmi.cbse.enemySystem.common.data.Entity;
import dk.sdu.mmmi.cbse.enemySystem.common.data.GameData;
import dk.sdu.mmmi.cbse.enemySystem.common.data.World;
import dk.sdu.mmmi.cbse.enemySystem.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.enemySystem.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.enemySystem.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.enemySystem.common.services.IGamePluginService;

public class PlayerPlugin implements IGamePluginService {

    private Entity player;

    public PlayerPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        player = createPlayerShip(gameData);
        world.addEntity(player);
    }

    private Entity createPlayerShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 2;
        float y = gameData.getDisplayHeight() / 2;
        float radians = 3.1415f / 2;
        
        Entity playerShip = new Player();
        playerShip.setRadius(3);
        
        playerShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        playerShip.add(new PositionPart(x, y, radians));
        playerShip.add(new LifePart(6,69));
        
        return playerShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(player);
    }

}
