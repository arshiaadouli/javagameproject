package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.*;

/**
 * @Author Arshia Adouli
 */
public class PickUpBehaviour implements Behaviour {

	/**
	 * @Author Arshia Adouli
	 *
	 * this behaviour allows zombies to pick up an Item from the ground with the condition of that item
	 * being an WeaponItem.
	 *
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return new PickUpItemAction(item)
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {

		if(actor.getNumArm() > 0) {
			ArrayList<Item> items = new ArrayList<>();
			
			for (Item i : map.locationOf(actor).getItems()) {
				items.add(i);
			}

			for (Item i : items) {
				if (i instanceof WeaponItem) {
					return new PickUpItemAction(i);
				}
			}
		}

		return null;
	}

}
