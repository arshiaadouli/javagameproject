package game;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.interfaces.Limb;
/**
 * arms are part of limbs ArrayList for every actor
 */
public class
Arm extends WeaponItem implements Limb {
	private boolean hasIt = false;		// if the variable hasIt is true it means the item can be craftable. otherwise it can be
	/**
	 * the dropped actors limbs can be used directly as weapons
	 * @param name : name of the arm
	 * @param b : boolean to make it craftable
	 */
	public Arm(String name, boolean b) {
		super(name, 'A', 18,  "blah");
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
		Arm arm = this;
		arm.setHasIt(true);
		return new PickUpItemAction(arm);
	}

	/**
	 *it uses override craft action for the item to craft current item to new item
	 * @param actor the actor who picks the item
	 * @return return 1 if actor can craft
	 */
	@Override
	public int craft(Actor actor) {
		actor.removeItemFromInventory(this);
		actor.addItemToInventory(new Club());
		System.out.println("craft action works");
		return 1;
	}
}
