package edu.monash.fit2099.interfaces;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * This interface provides the ability to add methods to Ground, without modifying code in the engine,
 * or downcasting references in the game.   
 */

public interface GroundInterface {
	public default boolean hasRipeCrop(Location l) {
		boolean retVal = false;
		
		for (Item i : l.getItems()) {
			if (i.asCrop(i) == null) {
				continue;
			}
			else {
				if (i.asCrop(i).getIsRipe()) {
					retVal = true;
				}
			}
		}
		
		return retVal;
	}
	
	public default boolean hasUnripeCrop(Location l) {
		boolean retVal = false;
		
		for (Item i : l.getItems()) {
			if (i.asCrop(i) == null) {
				continue;
			}
			else {
				if (!i.asCrop(i).getIsRipe()) {
					retVal = true;
				}
			}
		}
		
		return retVal;
	}
}
