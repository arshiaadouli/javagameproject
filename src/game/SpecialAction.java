package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class SpecialAction extends Action {
	
    @Override
    public String execute(Actor actor, GameMap map) {
        for(Item i : actor.getInventory()){
            if (i.craftable()) {
                new CraftAction(i).execute(actor, map);
            }
        }
        
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " craft limb";
    }
}
