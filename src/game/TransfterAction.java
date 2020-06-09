package game;

import edu.monash.fit2099.engine.*;

public class TransfterAction extends Action {

    private GameMap newMap;
    private int newX;
    private int newY;

    /**
     *
     * @param map the new map which the player is going to be transferred
     * @param x the new map x cor which the player is going to be transferred
     * @param y the new map y cor which the player is going to be transferred
     */
    public TransfterAction(GameMap map, int x, int y){
        this.newMap = map;
        this.newX = x;
        this.newY = y;
    }

    /**
     * this method remove the actor from the previous map and add the player to the new game map
     * @param actor The actor performing the action.
     * @param map new map which the player is transferred to.
     * @return the string which tells that the player has been transferred
     */

    @Override
    public String execute(Actor actor, GameMap map) {

        map.removeActor(actor);
        newMap.addActor(actor, newMap.at(newX, newY));





        return "player has been transferred to another map";
    }


    @Override
    public String menuDescription(Actor actor) {
        return "transport to alternative map";
    }
}
