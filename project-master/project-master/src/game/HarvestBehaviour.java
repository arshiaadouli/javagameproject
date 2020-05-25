package game;

import java.util.ArrayList;
import java.util.Collections;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * A class that generates HarvestAction if there is a crop object adjacent to the human and that is also ripe.
 * @author Joseph Yu
 *
 */

public class HarvestBehaviour implements Behaviour {
	
	/**
	 * Returns a HarvestAction that removes the crop object from the GameMap and either drops a new food object onto the ground or adds the food object into the player's inventory.
	 */
	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there a Ripe Crop around me?
		ArrayList<Exit> exitsAvailable = new ArrayList<>();
		ArrayList<Location> locationsWithRipeCrop = new ArrayList<>();
		
		for (Exit e : map.locationOf(actor).getExits()) {
			exitsAvailable.add(e);
		}
		
		for (Exit e : exitsAvailable) {
			if (e.getDestination().getGround().hasRipeCrop(e.getDestination())) {
				if (actor.getRipeCrop(e.getDestination().getItems()) != null) {
					locationsWithRipeCrop.add(e.getDestination());
				}
			}
		}
		
		if (locationsWithRipeCrop.size() > 0) {
			Collections.shuffle(locationsWithRipeCrop);
			return new HarvestAction(locationsWithRipeCrop.get(0));
		}
		
		return null;
	}
}