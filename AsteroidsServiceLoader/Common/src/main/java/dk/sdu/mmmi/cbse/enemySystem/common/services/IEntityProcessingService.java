package dk.sdu.mmmi.cbse.enemySystem.common.services;

import dk.sdu.mmmi.cbse.enemySystem.common.data.GameData;
import dk.sdu.mmmi.cbse.enemySystem.common.data.World;

public interface IEntityProcessingService {

    void process(GameData gameData, World world);
}
