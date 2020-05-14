package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;

public class SowAction extends Action {
	private Exit e;
	protected Random rand = new Random();
	
	public SowAction(Exit e) {
		this.e = e;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " plants some crops on a patch of dirt.";
		Crop newCrop = new Crop(actor.toString());
		
		for (int i = 0; i < newCrop.getCropLocations().size(); i++) {
			if (!newCrop.isInCropLocations(e.getDestination())) {
				e.getDestination().addItem(newCrop);
				newCrop.addToCropLocationsList(e.getDestination());
			}
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " plant crops on a patch of dirt nearby.";
	}
}
