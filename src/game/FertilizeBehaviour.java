package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class FertilizeBehaviour implements Behaviour {
	private Farmer f;
	private List<Location> cropLocations;
	
	public FertilizeBehaviour(Farmer f) {
		this.f = f;
		this.cropLocations = f.getCropLocations();
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there an UnripeCrop on me?		
		for (Location l : cropLocations) {
			if (map.locationOf(actor).x() == l.x() && map.locationOf(actor).y() == l.y()) {
				Crop c = f.getCropObj(l);
				return new FertilizeAction(l, c);
			}
		}
		return null;
	}
}
