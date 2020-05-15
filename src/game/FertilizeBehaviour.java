package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class FertilizeBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there an UnripeCrop on me?
		Crop newCrop = new Crop(actor.toString());
		
		for (Location l : newCrop.getCropLocations()) {
			if (map.locationOf(actor).x() == l.x() && map.locationOf(actor).y() == l.y()) {
				return new FertilizeAction(l);
			}
		}
		return null;
	}
}
