package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Action class that gives the Player options to aim at any actor currently on the GameMap.
 * @author Joseph Yu
 *
 */
public class SniperRifleAimMenuAction extends Action {
	private Actor target;
	private SniperRifle sniper;
	
	public SniperRifleAimMenuAction(Actor target, SniperRifle sniper) {
		this.target = target;
		this.sniper = sniper;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		sniper.incAim();
		
		if (sniper.getAim() == 1) {
			sniper.setAimTarget(target);
		}
		else if (!target.equals(sniper.getAimTarget())) {
			sniper.resetAim();
		}
		
		return actor + " aims at " + target;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " aim at " + target;
	}
	
	/**
	 * @return Sniper object that is currently aiming.
	 */
	public SniperRifle getSniper() {
		return sniper;
	}

}
