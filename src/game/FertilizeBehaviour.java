package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class FertilizeBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there an UnripeCrop on me?
		List<Item> itemsOnActor = map.locationOf(actor).getItems();
		
		for (Item i : itemsOnActor) {
			if (i instanceof UnripeCrop) {
				return new FertilizeAction(map.locationOf(actor));
			}
		}
		return null;
	}
}
