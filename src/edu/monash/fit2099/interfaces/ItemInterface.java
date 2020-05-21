package edu.monash.fit2099.interfaces;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.Crop;
import game.Food;

/**
 * This interface provides the ability to add methods to Ground, without modifying code in the engine,
 * or downcasting references in the game.
 * @Author Arshia Adouli
 */
public interface ItemInterface {

	/**
	 *
	 * @param actor the actor who crafts
	 * @param item the item that is crafted from player
	 * @return 0 which means it is not craftable as default
	 */
	public default int craft(Actor actor, Item item, GameMap map) {
		return 0;
	}


	/**
	 * knowing whether an item is craftable or not
	 * @return false as default
	 */
	public default boolean craftable() {
		return false;
	}


	
	public default Food asFood(Item i) {
		return i instanceof Food ? (Food) i : null;
	}
	
	public default Crop asCrop(Item i) {
		return i instanceof Crop ? (Crop) i : null;
	}
}
