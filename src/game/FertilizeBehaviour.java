package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class FertilizeBehaviour implements Behaviour {
	private List<Location> cropLocations;
	private List<Crop> cropObjs;
	
	public FertilizeBehaviour(Farmer f) {
		this.cropObjs = f.getCropObjs();
		this.cropLocations = f.getCropLocations();
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there an UnripeCrop on me?
		if (cropLocations != null) {
			for (int i = 0; i < cropLocations.size(); i++) {
				if (cropLocations.get(i).x() == map.locationOf(actor).x() && cropLocations.get(i).y() == map.locationOf(actor).y()) {
					for (int j = 0; j < cropLocations.size(); j++) {
						if (i == j) {
							Crop c = cropObjs.get(j);
							return new FertilizeAction(cropLocations.get(i), c);
						}
					}
				}
			}
		}
		return null;
	}
}
