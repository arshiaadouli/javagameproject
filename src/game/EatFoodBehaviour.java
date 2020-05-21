package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * A class that generates EatFoodAction if there is a food object in human's inventory.
 * @author Joseph Yu
 *
 */

public class EatFoodBehaviour implements Behaviour {
	private Human h;
	private Food f;
	
	public EatFoodBehaviour(Human h) {
		this.h = h;
	}
	
	/**
	 * Returns an EatFoodAction that removes the food object from human's inventory and heals the human by the amount that the food heals by.
	 */

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there a Food item in my inventory?
		for (Item i : h.getInventory()) {
			if (i.asFood(i) != null) {
				f = i.asFood(i);
				return new EatFoodAction(f);
			}
		}
		
		return null;
	}
}
