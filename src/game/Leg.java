package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.WeaponItem;

public class Leg extends WeaponItem implements Limb {

	public Leg(String name) {
		super(name, 'L', 18,  "blah");
		addCapability(ZombieCapability.ALIVE);
		allowableActions.add(new CraftAction());
	}


	@Override
	public int craft(Actor actor, Item item) {

		if(item instanceof Leg){
			actor.removeItemFromInventory(item);
			actor.addItemToInventory(new Mace());
			System.out.println("craft action works");
			return 1;
		}
	return 0;
	}
}
