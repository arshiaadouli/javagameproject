package edu.monash.fit2099.interfaces;

import java.util.List;

import edu.monash.fit2099.engine.*;
import game.*;

/**
 * This interface provides the ability to add methods to Actor, without modifying code in the engine,
 * or downcasting references in the game.   
 */

public interface ActorInterface {

	default public int getNumArm() {
		return 2;
	}

	default public int getNumLeg() {
		return 2;
	}

	default public int getNumTurn() {
		return 0;
	}

//	default public void addCraftAction(Actions actions, Actor actor) {
//		for (Item i : actor.getInventory()) {
//			if (i.craftable()) {
//				actions.add(new CraftAction(i));
//			}
//		}
//	}

	default public boolean crafter(){
		return true;
	}

	public default  Actions AllowableActions(){
		return  null;
	}

	default public Action addEatFoodAction(Actions actions, Actor actor) {
		// Is there a Food item in my inventory?
		for (Item i : actor.getInventory()) {
			if (i.asFood(i) != null) {
				actions.add(new EatFoodAction(i.asFood(i)));
			}
		}
		return null;
	}

	public default Player asPlayer(Actor a) {
		return a instanceof Player ? (Player) a : null;
	}
	
	public default Crop getUnripeCrop(List<Item> itemList) {
		Crop retVal = null;
		
		for (Item i : itemList) {
			if (i.asCrop(i) != null) {
				if (!i.asCrop(i).getIsRipe()) {
					retVal = i.asCrop(i);
				}
			}
		}
		return retVal;
	}
	
	public default Crop getRipeCrop(List<Item> itemList) {
		Crop retVal = null;
		
		for (Item i : itemList) {
			if (i.asCrop(i) != null) {
				if (i.asCrop(i).getIsRipe()) {
					retVal = i.asCrop(i);
				}
			}
		}
		return retVal;
	}
	
	public default void addHarvestAction(Actions actions, Actor actor, GameMap map) {
		List<Exit> actorExits = map.locationOf(actor).getExits();
		List<Item> itemsOnActor = map.locationOf(actor).getItems();
		boolean harvestActionAdded = false;
		
		// check if there are any ripe crop in actor's exits first.
		for (Exit e : actorExits) {
			List<Item> itemsOnLocation = e.getDestination().getItems();
			
			for (Item i : itemsOnLocation) {
				if (i.asCrop(i) != null && !harvestActionAdded) { // if i is a crop (ripe and unripe)
					if (i.asCrop(i).getIsRipe()) { // if i is a ripe crop
						actions.add(new HarvestAction(e.getDestination()));
						harvestActionAdded = true;
					}
				}
			}
		}
		
		// then check if actor is standing on any ripe crop.
		for (Item i : itemsOnActor) {
			if (i.asCrop(i) != null) {
				if (i.asCrop(i).getIsRipe() && !harvestActionAdded) {
					actions.add(new HarvestAction(map.locationOf(actor)));
					harvestActionAdded = true;
				}
			}
		}
	}
}
