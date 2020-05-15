package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class SowAction extends Action {
	private Location l;
	protected Random rand = new Random();
	
	public SowAction(Location l) {
		this.l = l;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " plants some crops on a patch of dirt.";
		Crop newCrop = new Crop(actor.toString());
		
		for (int i = 0; i < newCrop.getCropLocations().size(); i++) {
			if (!newCrop.isInCropLocations(l)) {
				l.addItem(newCrop);
				newCrop.addToCropLocationsList(l);
			}
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " plant crops on a patch of dirt nearby.";
	}
}
