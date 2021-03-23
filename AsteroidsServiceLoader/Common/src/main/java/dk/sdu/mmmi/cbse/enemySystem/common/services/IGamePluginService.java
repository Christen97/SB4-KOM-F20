package dk.sdu.mmmi.cbse.enemySystem.common.services;

import dk.sdu.mmmi.cbse.enemySystem.common.data.GameData;
import dk.sdu.mmmi.cbse.enemySystem.common.data.World;

public interface IGamePluginService {
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
