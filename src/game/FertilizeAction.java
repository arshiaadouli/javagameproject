package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class FertilizeAction extends Action {
	Location l;
	Crop c;
	
	public FertilizeAction(Location l, Crop c) {
		this.l = l;
		this.c = c;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " fertlized an Unripe Crop";
		List<Item> itemsOnLocation = l.getItems();
		
		if (itemsOnLocation.size() > 0) {
			for (Item i : itemsOnLocation) {
				if (i.equals(c)) {
					for (int a = 0; a < 20; a++) {
						c.tick(l);
					}
				}
			}
		}
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " fertilizes an Unripe Crop";
	}
}
