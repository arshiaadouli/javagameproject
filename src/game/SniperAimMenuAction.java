package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SniperAimMenuAction extends Action {
	private Actor target;
	private SniperRifle sniper;
	
	public SniperAimMenuAction(Actor target, SniperRifle sniper) {
		this.target = target;
		this.sniper = sniper;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if (sniper.getAimTarget() == null) {
			sniper.setAimTarget(target);
		}
		else {
			sniper.resetAim();
		}
		
		return actor + " aims at " + target;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " aim at " + target;
	}

}
