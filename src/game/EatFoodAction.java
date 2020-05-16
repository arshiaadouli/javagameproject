package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class EatFoodAction extends Action {
	private Food food;
	
	public EatFoodAction(Food food) {
		this.food = food;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = null;
		
		retVal = actor + " eats " + food.toString() + " and heals for " + food.getHealsFor();
		actor.removeItemFromInventory(food);
		actor.heal(food.getHealsFor());
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " eat " + food.toString() + " from inventory";
	}
}
