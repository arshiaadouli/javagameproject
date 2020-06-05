package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * it is a class which returns ChantingAction() as get action output.
 */
public class ChantingBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        return new ChantingAction();
    }
}
