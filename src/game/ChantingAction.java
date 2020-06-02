package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

import java.util.Random;


public class ChantingAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        for(int i =0; i < 5 ; i++){
            try{
                Random random = new Random();
                int x = random.nextInt(map.getXRange().max());
                int y = random.nextInt(map.getYRange().max());
                map.addActor(new Zombie("zombie"), map.at(x,y));

            }
            catch (Exception e){}

        }
        return "5 new zombies has been added to the map";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
