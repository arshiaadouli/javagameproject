package edu.monash.fit2099.interfaces;

import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import game.Crop;
import game.Food;
import game.Player;

/**
 * This interface provides the ability to add methods to Actor, without modifying code in the engine,
 * or downcasting references in the game.   
 */

public interface ActorInterface {	
	public default void harvestCrop(Actor actor, GameMap map, Location l) {
		Crop c = actor.getRipeCrop(l.getItems());
		
		if (actor.asPlayer(actor) != null) {
			actor.addItemToInventory(new Food("Food", 'f'));
			
			if (c != null) {
				l.removeItem(c);
			}
		}
		else {
			l.addItem(new Food("Food", 'f'));
			l.removeItem(c);
		}
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
}
