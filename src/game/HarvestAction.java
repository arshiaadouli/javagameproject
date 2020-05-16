package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class HarvestAction extends Action {
	private Location l;
	private Class<?> playerClass;
	
	public HarvestAction(Location l, Class<?> cls) {
		this.l = l;
		playerClass = cls;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " harvested a Ripe Crop nearby.";
		// check if actor is player or not
		if (playerClass.isInstance(actor)) {
			actor.addItemToInventory(new Food(actor.toString(), 'F'));
		}
		else {
			l.addItem(new Food(actor.toString(), 'F'));
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " harvests a Ripe Crop nearby.";
	}
}
