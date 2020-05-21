package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.*;

public class PickUpBehaviour implements Behaviour {

	public PickUpBehaviour() {

	}

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
