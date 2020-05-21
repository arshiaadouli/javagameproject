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

	public default boolean crafter() {
		return true;
	}

	public default  Actions AllowableActions() {
		return  null;
	}

	public default Player asPlayer(Actor a) {
		return a instanceof Player ? (Player) a : null;
	}

	public default Actions AllowableActions(GameMap map) {
		return null;
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
