package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

import java.util.Random;


public class ChantingAction extends Action {
    /**
     * creates 5 zombies randomly in the current map
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * this action has been used for the mambo marie.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        for(int i =0; i < 5 ; i++){

                Random random = new Random();
                int x = random.nextInt(map.getXRange().max());
                int y = random.nextInt(map.getYRange().max());
                if(!map.isAnActorAt(map.at(x, y)))
                map.addActor(new Zombie("zombie"), map.at(x,y));



        }
        return "5 new zombies has been added to the map";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
