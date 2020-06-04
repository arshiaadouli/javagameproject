package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

public class TransfterAction extends Action {
    GameMap newMap;
    public TransfterAction(GameMap map){
        this.newMap = map;
    }
    @Override
    public String execute(Actor actor, GameMap map) {

        map.removeActor(actor);
        newMap.addActor(actor, newMap.at(0, 0));



        return "player has been transferred to another map";
    }


    @Override
    public String menuDescription(Actor actor) {
        return "transport to alternative map";
    }
}
