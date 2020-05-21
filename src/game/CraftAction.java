package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

import java.util.ArrayList;

public class CraftAction extends Action {

	Item item;
	String craftedItem;

	/**@Author Arshia Adouli
	 * @param i: item which the actor crafts
	 **/

	public CraftAction(Item i){
		item = i;
	}

	/**
	 * this action allows an actor to craft item to another item(weapon) if the item is
	 * craftable.
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return the expression which says an item is crafted to ...
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		ArrayList<Item> items = new ArrayList<>();

		for(Item i : actor.getInventory()){
			items.add(i);
		}
		
		for(Item i : items) {
			if (i.craft(actor, i, map) == 1) {
				return "a " + actor.getInventory().get(actor.getInventory().size() - 1).toString() + " has been added to " + actor.toString() + "'s inventory";
			}
		}
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " crafted a " + item.toString();
	}
}
