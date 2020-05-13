package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;

public class SowAction extends Action {
	private Exit e;
	
	public SowAction(Exit e) {
		this.e = e;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " sows on a patch of dirt nearby.";
		UnripeCrop unripeCrop = new UnripeCrop(actor.toString());
		
		// put unripeCrop into map
		e.getDestination().addItem(unripeCrop);
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " sow seeds on a patch of dirt nearby.";
	}
}
