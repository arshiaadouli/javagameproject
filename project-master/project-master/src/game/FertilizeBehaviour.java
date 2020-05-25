package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * A class that generates FertilizeAction if there is a crop object on the human's location that is also unripe.
 * @author josep
 *
 */

public class FertilizeBehaviour implements Behaviour {
	private Farmer f;
	
	public FertilizeBehaviour(Farmer f) {
		this.f = f;
	}
	
	/**
	 * Returns a FertilizeAction that fertilizes a crop on the actor's location in the GameMap.
	 */

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there an UnripeCrop on me?
		List<Item> itemsOnActor = map.locationOf(actor).getItems();
		
		if (f.getUnripeCrop(itemsOnActor) != null) {
			return new FertilizeAction(f.getUnripeCrop(itemsOnActor));
		}
		
		return null;
	}
}
