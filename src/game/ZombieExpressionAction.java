package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * this class will address zombie to spend one turn to just say zombie expression(e.g. "braaaaaaaaaaaaaaains")
 */
public class ZombieExpressionAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        return actor.toString() + " says braaaaaaaaaaaaaaains";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
