package game;

import edu.monash.fit2099.engine.*;

/**
 * Legs are part of limbs ArrayList for every actor
 */
public class Leg extends WeaponItem implements Limb {

	private boolean hasIt = false;

	/**
	 * the dropped actors limbs can be used directly as weapons
	 * @param name : name of the leg
	 * @param b : boolean to make it craftable
	 */
	public Leg(String name, boolean b) {
		super(name, 'L', 18, "blah");
		addCapability(ZombieCapability.ALIVE);
		this.hasIt = b;
	}

	/**
	 * knowing whether this class is craftable or not
	 * @return true or false
	 */
	public boolean craftable() {
		return hasIt;
	}

	/**
	 * change the value of HasIt to true
	 * @param hasIt
	 */

	public void setHasIt(boolean hasIt) {
		this.hasIt = hasIt;
	}

	/**
	 * change the value of hasIt to true when picking up the item
	 * @return new PickUpItemAction()
	 */
	@Override

	public PickUpItemAction getPickUpAction() {

		this.setHasIt(true);
		System.out.println("the boolean is " + craftable());
		Leg leg = this;
		leg.setHasIt(true);
		return new PickUpItemAction(leg);
	}

	/**
	 *
	 * @param actor the actor who picks the item
	 * @param item item which actor picks it up
	 * @return return 1 if actor can craft
	 */
	@Override
	public int craft(Actor actor, Item item, GameMap map) {
		actor.removeItemFromInventory(item);
		actor.addItemToInventory(new Mace());
		System.out.println("craft action works");
		return 1;
	}
}
