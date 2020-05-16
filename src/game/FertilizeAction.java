package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class FertilizeAction extends Action {
	Crop c;
	
	public FertilizeAction(Crop c) {
		this.c = c;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " fertilized an Unripe Crop";
		
		c.fertilizeCrop();
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " fertilizes an Unripe Crop";
	}
}
