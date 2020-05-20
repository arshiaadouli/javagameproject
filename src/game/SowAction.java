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
	private Location l;
	/**
	 * Container for the farmer that is sowing.
	 */
	private Farmer f;
	/**
	 * Container for the crop that will be on the GameMap.
	 */
	private Crop c;
	protected Random rand = new Random();
	
	public SowAction(Location l, Farmer f, Crop c) {
		this.l = l;
		this.f = f;
		this.c = c;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " plants some crops on a patch of dirt";
		
		if (rand.nextFloat() <= 0.33) {
			this.l.addItem(this.c);
			
			try {
				f.addToCropLocations(this.l, this.c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			retVal = null;
		}
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " plant crops on a patch of dirt nearby";
	}
}
