package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.GameMap;

/**
 * Action for human to eat food from their inventory.
 * @author Joseph Yu
 *
 */

public class EatFoodAction extends Action {
	/**
	 * Container for the food object that is to be eaten (removed from inventory).
	 */
	private Food food;
	
	public EatFoodAction(Food food) {
		this.food = food;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " eats " + food.toString() + " and heals for " + food.getHealsFor();
		
		DropItemAction dia = new DropItemAction(food);
		
		dia.execute(actor, map);
		map.locationOf(actor).removeItem(food);
		actor.heal(food.getHealsFor());
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " eat " + food.toString() + " from inventory";
	}
}
