package game;

import edu.monash.fit2099.engine.*;

/**
 * Base class for Actors in the Zombie World
 * @author ram
 *
 */
public abstract class ZombieActor extends Actor {
	
	public ZombieActor(String name, char displayChar, int hitPoints, ZombieCapability team) {
		super(name, displayChar, hitPoints);
		
		addCapability(team);
	}

	public Actions hasCraftAction(Actions actions){
		Actions actionsCraft = new Actions();
		for (Item i : this.getInventory()) {
			if (i.craftable()) {
				actionsCraft.add(new CraftAction(i));
			}
		}
		return actionsCraft;
	}

	@Override

	public Actions AllowableActions(){
		Actions actions = new Actions();
		if(this.crafter()){
			actions.add(hasCraftAction(actions));
		}
		return actions;
	}


	


	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions list = super.getAllowableActions(otherActor, direction, map);
		if (otherActor.hasCapability(ZombieCapability.UNDEAD) != this.hasCapability(ZombieCapability.UNDEAD))
			list.add(new AttackAction(this));

		return list;
	}
}
