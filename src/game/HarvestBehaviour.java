package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class HarvestBehaviour implements Behaviour {
	private List<Location> ripeCropLocations;
	
	public HarvestBehaviour(List<Location> ripeCropLocations) {
		this.ripeCropLocations = ripeCropLocations;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		List<Exit> exitsAvailable = map.locationOf(actor).getExits();
		ArrayList<Exit> exitsWithRipeCrop = new ArrayList<Exit>();
		
		for (Exit e : exitsAvailable) {
			for (Location l : ripeCropLocations) {
				if (e.getDestination().x() == l.x() && e.getDestination().y() == l.y()) {
					exitsWithRipeCrop.add(e);
				}
			}
		}
		
		if (exitsWithRipeCrop.size() > 0) {
			Collections.shuffle(exitsWithRipeCrop);
			return new HarvestAction(exitsWithRipeCrop.get(0).getDestination());
		}
		
		return null;
	}
}