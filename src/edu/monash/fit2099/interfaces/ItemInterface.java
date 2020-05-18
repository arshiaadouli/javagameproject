package edu.monash.fit2099.interfaces;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.Crop;
import game.Food;

/**
 * This interface provides the ability to add methods to Ground, without modifying code in the engine,
 * or downcasting references in the game.   
 */
public interface ItemInterface {

	default public int craft(Actor actor, Item item, GameMap map){

		return 0;
	}


	default public boolean isHasIt(){return false;}
	public default Food asFood(Item i) {
		return i instanceof Food ? (Food) i : null;
	}
	
	public default Crop asCrop(Item i) {
		return i instanceof Crop ? (Crop) i : null;
	}
}
