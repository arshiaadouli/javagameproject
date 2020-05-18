package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class SowAction extends Action {
	private Location l;
	private Farmer f;
	private Crop c;
	protected Random rand = new Random();
	
	public SowAction(Location l, Farmer f, Crop c) {
		this.l = l;
		this.f = f;
		this.c = c;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " plants some crops on a patch of dirt";
		
		if (rand.nextFloat() <= 0.33) {
			this.l.addItem(this.c);
			f.addToCropLocations(this.l, this.c);
		}
		else {
			retVal = actor + " tried to plant some crops on a patch of dirt but failed";
		}
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " plant crops on a patch of dirt nearby";
	}
}
