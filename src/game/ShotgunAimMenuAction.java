package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ShotgunAimMenuAction extends Action {
	private Shotgun shotgun;
	
	public ShotgunAimMenuAction(Shotgun shotgun) {
		this.shotgun = shotgun;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return null;
	}
	
}
