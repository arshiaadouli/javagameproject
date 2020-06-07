package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

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
		
		if (sniper.getAimTarget() != null) {
			if (sniper.getAimTarget().equals(target)) {
				sniper.setAimTarget(target);
			}
			else {
				sniper.resetAim();
				sniper.setAimTarget(null);
			}
		}
		else {
			sniper.resetAim();
		}
		
		System.out.println("Aim: " + sniper.getAim());
		return actor + " aims at " + target;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " aim at " + target;
	}
	
	public SniperRifle getSniper() {
		return sniper;
	}

}
