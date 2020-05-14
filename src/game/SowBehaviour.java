package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class SowBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there a patch of dirt near me?		
		List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		List<Exit> availableExits = new ArrayList<Exit>();
		
		for (Exit e : exits) {
			List<Item> itemsOnLocation = e.getDestination().getItems();
			boolean hasCropItems = false;
			
			for (Item i : itemsOnLocation) {
				if (i instanceof UnripeCrop || i instanceof RipeCrop) {
					hasCropItems = true;
				}
			}
			
			if (!hasCropItems) {
				availableExits.add(e);
			}
		}
		
		if (availableExits.size() > 0) {
			Collections.shuffle(availableExits);
			return new SowAction(availableExits.get(0));
		}
		return null;
	}
}
