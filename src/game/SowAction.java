package game;

import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class SowAction extends Action {
	private Location l;
	private List<Location> cropLocations;
	private Farmer f;
	protected Random rand = new Random();
	
	public SowAction(Location l, Farmer f) {
		this.l = l;
		this.cropLocations = f.getCropLocations();
		this.f = f;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " plants some crops on a patch of dirt.";
		
		for (int i = 0; i < cropLocations.size(); i++) {
			if (!f.isInCropLocations(l)) {
				Crop c = new Crop(actor.toString());
				
				l.addItem(c);
				f.addToCropLocations(l, c);
			}
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " plant crops on a patch of dirt nearby.";
	}
}
