package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SowBehaviour implements Behaviour {

	public SowBehaviour() {
		
	}
	
	public Action sow(Actor actor, GameMap map) {
		
		return null;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		return sow(actor, map);
	}
}
