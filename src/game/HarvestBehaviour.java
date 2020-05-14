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

	@Override
	public Action getAction(Actor actor, GameMap map) {
		Crop newCrop = new Crop(actor.toString());
		List<Exit> exitsAvailable = map.locationOf(actor).getExits();
		ArrayList<Exit> exitsWithRipeCrop = new ArrayList<Exit>();
		
		if (newCrop.isInCropLocations(map.locationOf(actor))) {
			return new HarvestAction(map.locationOf(actor));
		}
		
		for (int j = 0; j < exitsAvailable.size(); j++) {
			Location l = exitsAvailable.get(j).getDestination();
			if (newCrop.isInCropLocations(l) && newCrop.getIsRipe()) {
				exitsWithRipeCrop.add(exitsAvailable.get(j));
			}
		}
		
		if (exitsWithRipeCrop.size() > 0) {
			Collections.shuffle(exitsWithRipeCrop);
			return new HarvestAction(exitsWithRipeCrop.get(0).getDestination());
		}
		
		return null;
	}

}
