package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class FertilizeAction extends Action {
	Location l;
	
	public FertilizeAction(Location l) {
		this.l = l;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " fertlized an Unripe Crop.";
		List<Item> itemsOnLocation = l.getItems();
		
		for (Item i : itemsOnLocation) {
			if (i.getDisplayChar() == 'c') { // need to find another way to do this.
				for (int a = 0; a < 20; a++) {
					i.tick(l);
				}
			}
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " fertilizes an Unripe Crop.";
	}
}
