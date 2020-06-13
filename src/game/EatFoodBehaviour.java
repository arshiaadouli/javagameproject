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
	private Human human;
	private Food food;
	
	public EatFoodBehaviour(Human human) {
		this.human = human;
	}
	
	/**
	 * Returns an EatFoodAction that removes the food object from human's inventory and heals the human by the amount that the food heals by.
	 */

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there a Food item in my inventory?
		for (Item i : human.getInventory()) {
			if (i.asFood(i) != null) {
				food = i.asFood(i);
				return new EatFoodAction(food);
			}
		}
		
		return null;
	}
}
