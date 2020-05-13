package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
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
		List<Item> itemList = l.getItems();
		
		for (Item item : itemList) {
			if (item.getDisplayChar() == 'c') {
				for (int i = 0; i < 10; i++) {
					item.tick(l);
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
