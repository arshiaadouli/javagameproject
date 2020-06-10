package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * this class represents the suicide action of player in every turn(quit game)
 */
public class DieAction extends Action {
    /**
     * this method will remove the player from the map which
     * it is on therefore the game should end because there are
     * no player which the world processes it turn.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
       map.removeActor(actor);


        return "player has been died";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "quit game";
    }
}
