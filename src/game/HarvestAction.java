package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class HarvestAction extends Action {
	private Location l;
	private Farmer f;
	
	public HarvestAction(Location l, Farmer f) {
		this.l = l;
		this.f = f;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " harvested a Ripe Crop nearby.";
		// remove crop item from the location
		// check if actor is player or not
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " harvests a Ripe Crop nearby.";
	}
}
