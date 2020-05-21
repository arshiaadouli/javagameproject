package game;

import java.util.List;

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

	public Actions hasCraftAction() {
		Actions actionsCraft = new Actions();
		for (Item i : this.getInventory()) {
			if (i.craftable()) {
				actionsCraft.add(new CraftAction(i));
			}
		}
		
		return actionsCraft;
	}
	
	public Actions addEatFoodAction() {
		Actions actions = new Actions();
		// Is there a Food item in my inventory?
		for (Item i : this.getInventory()) {
			if (i.asFood(i) != null) {
				actions.add(new EatFoodAction(i.asFood(i)));
			}
		}
		
		return actions;
	}
	
	public Actions addHarvestAction(GameMap map) {
		Actions actions = new Actions();
		List<Exit> actorExits = map.locationOf(this).getExits();
		List<Item> itemsOnActor = map.locationOf(this).getItems();
		boolean harvestActionAdded = false;
		
		// check if there are any ripe crop in actor's exits first.
		for (Exit e : actorExits) {
			List<Item> itemsOnLocation = e.getDestination().getItems();
			
			for (Item i : itemsOnLocation) {
				if (i.asCrop(i) != null && !harvestActionAdded) { // if i is a crop (ripe and unripe)
					if (i.asCrop(i).getIsRipe()) { // if i is a ripe crop
						actions.add(new HarvestAction(e.getDestination()));
						harvestActionAdded = true;
						return actions;
					}
				}
			}
		}
		
		// then check if actor is standing on any ripe crop.
		for (Item i : itemsOnActor) {
			if (i.asCrop(i) != null) {
				if (i.asCrop(i).getIsRipe() && !harvestActionAdded) {
					actions.add(new HarvestAction(map.locationOf(this)));
					harvestActionAdded = true;
					return actions;
				}
			}
		}
		
		return actions;
	}

	@Override
	public Actions AllowableActions(GameMap map) {
		Actions actions = new Actions();
		
		if (this.crafter()) {
			actions.add(hasCraftAction());
		}
		
		actions.add(addHarvestAction(map));
		actions.add(addEatFoodAction());
		
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
