package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class EatFoodBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there a Food item in my inventory?
		List<Item> actorInventory = actor.getInventory();
		
		for (Item item : actorInventory) {
			if (item instanceof Food) {
				return new EatFoodAction(item);
			}
		}
		return null;
	}
}
