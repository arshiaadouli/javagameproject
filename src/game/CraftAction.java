package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

import java.util.ArrayList;

public class CraftAction extends Action {

	String item;
	String craftedItem;


	@Override
	public String execute(Actor actor, GameMap map) {
		ArrayList<Item> items = new ArrayList<>();

		for(Item i : actor.getInventory()){
			items.add(i);
		}
		for(Item i : items) {
			if (i.craft(actor, i) == 1) {
//				i.craft(actor, i);
				item = i.toString();
				craftedItem = actor.getInventory().get(actor.getInventory().size() - 1).toString();
				return "a " + actor.getInventory().get(actor.getInventory().size() - 1).toString() + " has been added to " + actor.toString() + " inventory.";
			}
		}

		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return "craft limb";
	}
}
