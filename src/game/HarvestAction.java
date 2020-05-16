package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class HarvestAction extends Action {
	static private int foodNum = 0;
	private Location l;
	private Class<?> playerClass;
	
	public HarvestAction(Location l, Class<?> cls) {
		this.l = l;
		playerClass = cls;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " harvested a Ripe Crop nearby";
		
		if (playerClass.isInstance(actor)) {
			HarvestAction.foodNum += 1;
			ArrayList<Item> itemsOnLocation = new ArrayList<>();
			
			actor.addItemToInventory(new Food("Food " + HarvestAction.foodNum, 'F'));
			
			for (Item i : map.locationOf(actor).getItems()) {
				itemsOnLocation.add(i);
			}
			
			for(Item i : itemsOnLocation) {
				if(i instanceof Crop) {
					map.locationOf(actor).removeItem(i);
				}
			}
		}
		else {
			l.addItem(new Food(actor.toString(), 'F'));
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " harvests a Ripe Crop nearby";
	}
}
