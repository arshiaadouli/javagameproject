package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.WeaponItem;

public class Arm extends WeaponItem implements Limb {

	public Arm(String name) {
		super(name, 'A', 18, "blah");
		addCapability(ZombieCapability.ALIVE);
		allowableActions.add(new CraftAction());
	}

	@Override
	public int craft(Actor actor, Item item) {
		if(item instanceof Arm){

			actor.removeItemFromInventory(item);
			actor.addItemToInventory(new Club());
			System.out.println("craft action works");
			return 1;

		}

		return 0;
	}
}
