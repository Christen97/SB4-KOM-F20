package dk.sdu.mmmi.cbse.enemySystem.asteroid;

import dk.sdu.mmmi.cbse.enemySystem.common.data.Entity;
import dk.sdu.mmmi.cbse.enemySystem.common.data.GameData;
import dk.sdu.mmmi.cbse.enemySystem.common.data.World;
import dk.sdu.mmmi.cbse.enemySystem.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.enemySystem.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.enemySystem.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.enemySystem.common.data.entityparts.SplitterPart;
import dk.sdu.mmmi.cbse.enemySystem.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.enemySystem.common.services.IPostEntityProcessingService;
//import org.openide.util.lookup.ServiceProvider;
//import org.openide.util.lookup.ServiceProviders;
//@ServiceProviders(value = {
// @ServiceProvider(service = IPostEntityProcessingService.class),
// @ServiceProvider(service = IGamePluginService.class)
//})
public class AsteroidPlugin
  implements IGamePluginService, IPostEntityProcessingService
{
  private Entity asteroid;

    @Override
    public void start(GameData gameData, World world) {
       asteroid = createLargeAsteroid(gameData);
       world.addEntity(asteroid);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(asteroid);
    }

    @Override
    public void process(GameData gameData, World world) {
        
    }
    
    private Asteroid createLargeAsteroid(GameData gameData){
       float speed = (float) Math.random() * 10f + 40f;
       float radians = 3.1415f / 2 + (float) Math.random();
        float x = gameData.getDisplayWidth() / 2 + 100;
        float y = gameData.getDisplayHeight() / 2 + 50;
        Entity asteroid = new Asteroid(AsteroidType.LARGE);

        asteroid.add(new MovingPart(0, speed, speed, 0));
        asteroid.add(new PositionPart(x, y, radians));
        asteroid.add(new LifePart(6, 69));
        asteroid.add(new SplitterPart());
        asteroid.setRadius(15);

        return (Asteroid) asteroid;  
    }
}
