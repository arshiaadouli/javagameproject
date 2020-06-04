package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SniperAimAction extends Action {
	private Actor target;
	private SniperRifle sniper;
	
	public SniperAimAction(Actor target, SniperRifle sniper) {
		this.target = target;
		this.sniper = sniper;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		sniper.incAim();
		return actor + " aims at " + target;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " aim at " + target;
	}
	
	@Override
	public Action getNextAction() {
		return null;
	}

}
