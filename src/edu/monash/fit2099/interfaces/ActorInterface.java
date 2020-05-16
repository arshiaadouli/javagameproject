package edu.monash.fit2099.interfaces;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import game.Food;
import game.Player;

/**
 * This interface provides the ability to add methods to Actor, without modifying code in the engine,
 * or downcasting references in the game.   
 */

public interface ActorInterface {
	public default void harvestCrop(Actor actor, GameMap map, Location l) {
		if (actor.asPlayer(actor) != null) {
			ArrayList<Item> itemsOnLocation = new ArrayList<>();
			
			actor.addItemToInventory(new Food("Food", 'F'));
			
			for (Item i : map.locationOf(actor).getItems()) {
				itemsOnLocation.add(i);
			}
			
			for(Item i : itemsOnLocation) {
				if(i.asCrop(i) != null) {
					map.locationOf(actor).removeItem(i);
				}
			}
		}
		else {
			l.addItem(new Food("Food", 'F'));
		}
	}
	
	public default Player asPlayer(Actor a) {
		return a instanceof Player ? (Player) a : null;
	}
}
