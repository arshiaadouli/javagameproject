package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class RangeAttackAction extends Action {
	private Actor target;

	@Override
	public String execute(Actor actor, GameMap map) {
		
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}

}
