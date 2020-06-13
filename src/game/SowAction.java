package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * Action for farmers to sow a new crop object onto a patch of dirt near the farmer.
 * @author Joseph Yu
 *
 */

public class SowAction extends Action {
	/**
	 * Container for the location of where the farmer is going to sow the crop on.
	 */
	private Location targetLocation;
	/**
	 * Container for the farmer that is sowing.
	 */
	private Farmer farmer;
	/**
	 * Container for the crop that will be on the GameMap.
	 */
	private Crop newCrop;
	protected Random rand = new Random();
	
	public SowAction(Location targetLocation, Farmer farmer, Crop crop) {
		this.targetLocation = targetLocation;
		this.farmer = farmer;
		this.newCrop = crop;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " plants some crops on a patch of dirt";
		
		if (rand.nextDouble() <= 0.33) {
			this.targetLocation.addItem(this.newCrop);
			
			try {
				farmer.addToCropLocations(this.targetLocation, this.newCrop);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			retVal = actor + " failed to plant some crops on a patch of dirt";
		}
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " plant crops on a patch of dirt nearby";
	}
}
