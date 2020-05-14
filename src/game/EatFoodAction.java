package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class EatFoodAction extends Action {
	private Item item;
	
	public EatFoodAction(Item item) {
		this.item = item;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		// copied line 18 from Item class under the method "public Weapon asWeapon()" since we're not allowed to change and add to Item class
		Food f = item instanceof Food ? (Food) item : null;
		String retVal = null;
		
		if (f != null) {
			retVal = actor + " eats food and heals for " + f.getHealsFor();
			actor.removeItemFromInventory(item);
			actor.heal(f.getHealsFor());
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " eat food from inventory.";
	}
}
