package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class HarvestAction extends Action {
	private Location l;
	
	public HarvestAction(Location l) {
		this.l = l;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " harvested a Ripe Crop nearby.";
		List<Item> itemList = l.getItems();
		
		for (Item item : itemList) {
			if (item.getDisplayChar() == 'C') {
				if (actor instanceof Player) {
					actor.addItemToInventory(new Food("Food", 'F'));
				}
				else {
					l.addItem(new Food("Food", 'F'));
				}
				l.removeItem(item);
			}
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " harvests a Ripe Crop nearby.";
	}
}
