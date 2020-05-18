package game;

import edu.monash.fit2099.engine.*;

public class Leg extends WeaponItem implements Limb {

	boolean hasIt = false;
	public Leg(String name, boolean b) {
		super(name, 'L', 18,  "blah");
		addCapability(ZombieCapability.ALIVE);
		this.hasIt = b;
		if(isHasIt()) {
			allowableActions.add(new CraftAction());
		}
//		allowableActions.add(new SpecialAction());
	}

	public boolean isHasIt() {
		return hasIt;
	}

	public void setHasIt(boolean hasIt) {
		this.hasIt = hasIt;
	}

	@Override
	public PickUpItemAction getPickUpAction(){

		this.setHasIt(true);
		System.out.println("the boolean is " + isHasIt());
		Leg leg = this;
		leg.setHasIt(true);
		return new PickUpItemAction(leg);
	}
	@Override
	public int craft(Actor actor, Item item, GameMap map) {

		if(item instanceof Leg){
			actor.removeItemFromInventory(item);
			actor.addItemToInventory(new Mace());
			System.out.println("craft action works");
			return 1;
		}
		return 0;
	}
}
