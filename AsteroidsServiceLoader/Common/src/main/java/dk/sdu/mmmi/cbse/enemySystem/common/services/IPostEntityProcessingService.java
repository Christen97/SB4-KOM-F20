package dk.sdu.mmmi.cbse.enemySystem.common.services;

import dk.sdu.mmmi.cbse.enemySystem.common.data.GameData;
import dk.sdu.mmmi.cbse.enemySystem.common.data.World;

/**
 *
 * @author jcs
 */
public interface IPostEntityProcessingService  {
        void process(GameData gameData, World world);
}
