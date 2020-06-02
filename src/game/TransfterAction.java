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

//        ArrayList<GameMap> gameMaps = Application.temp;
//
//        GameMap gameMap1 = gameMaps.get(0);
//        GameMap gameMap2 = gameMaps.get(1);
//
//        if(gameMap1.contains(actor)){
//            gameMap1.removeActor(actor);
//            gameMap2.addActor(actor, gameMap2.at(0, 0));
//        }
//q
//        else if(gameMap2.contains(actor)){
//            gameMap2.removeActor(actor);
//            gameMap1.addActor(actor, gameMap1.at(42, 15));
//        }
//
//

        map.removeActor(actor);
        newMap.addActor(actor, newMap.at(0, 0));



        return "player has been transferred to another map";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "transport to alternative map";
    }
}
