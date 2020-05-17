package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class FertilizeBehaviour implements Behaviour {
	private Farmer f;
	
	public FertilizeBehaviour(Farmer f) {
		this.f = f;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there an UnripeCrop on me?
		List<Item> itemsOnActor = map.locationOf(actor).getItems();
		
		if (f.getUnripeCropOnActor(itemsOnActor) != null) {
			return new FertilizeAction(f.getUnripeCropOnActor(itemsOnActor));
		}
		return null;
	}
}
