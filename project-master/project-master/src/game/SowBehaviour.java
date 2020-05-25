package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * A class that generates SowAction if there is an empty space adjacent to the farmer on the GameMap and the space doesn't already have a crop object there.
 * @author Joseph Yu
 *
 */

public class SowBehaviour implements Behaviour {
	private Farmer f;
	
	public SowBehaviour(Farmer f) {
		this.f = f;
	}

	/**
	 * Returns a SowAction that puts a new crop object onto the GameMap after checking whether the space is valid or not.
	 */
	
	@Override
	public Action getAction(Actor actor, GameMap map) {		
		List<Exit> exits = map.locationOf(actor).getExits();
		ArrayList<Exit> exitsAvailable = new ArrayList<Exit>();
		Crop c = new Crop(actor.toString());
		
		for (Exit e : exits) {
			List<Item> itemsOnLocation = e.getDestination().getItems();
			
			if (actor.getRipeCrop(itemsOnLocation) == null && actor.getUnripeCrop(itemsOnLocation) == null) {
				exitsAvailable.add(e);
			}
		}
		
		if (exitsAvailable.size() > 0) {
			Collections.shuffle(exitsAvailable);
			return new SowAction(exitsAvailable.get(0).getDestination(), f, c);
		}
		return null;
	}
}
