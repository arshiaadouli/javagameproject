package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * Action for humans to harvest crop objects adjacent to them.
 * @author Joseph Yu
 *
 */

public class HarvestAction extends Action {
	/**
	 * Container for the location of the ripe crop that is to be harvested by the human.
	 */
	
	private Location l;
	
	public HarvestAction(Location l) {
		this.l = l;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " harvested a Ripe Crop nearby";
		
		Crop c = actor.getRipeCrop(l.getItems());
		
		if (actor.asPlayer(actor) != null) {
			actor.addItemToInventory(new Food("Food"));
			
			if (c != null) {
				l.removeItem(c);
			}
		}
		else {
			l.addItem(new Food("Food"));
			l.removeItem(c);
		}
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " harvests a Ripe Crop nearby";
	}
}
