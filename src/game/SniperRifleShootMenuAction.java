package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SniperRifleShootMenuAction extends Action {
	private Actor target;
	private SniperRifle sniper;
	
	public SniperRifleShootMenuAction(Actor target, SniperRifle sniper) {
		this.target = target;
		this.sniper = sniper;
		sniper.setShootTarget(target);
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {		
		sniper.empty(); // action will consume 1 bullet even if it misses, that's why it's not included in the if statement body
		if (sniper.getAim() == 0) {
			target.hurt(sniper.damage());
			new Corpse().execute(map, target);
			return actor + " shoots " + target + " for " + sniper.damage() + " damage";
		}
		else if (sniper.getAimTarget().equals(target)) {
			target.hurt(sniper.damage());
			new Corpse().execute(map, target);
			return actor + " shoots " + target + " for " + sniper.damage() + " damage";
		}
		else {
			sniper.resetAim();
			target.hurt(sniper.damage());
			new Corpse().execute(map, target);
			return actor + " shoots " + target + " for " + sniper.damage() + " damage";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " shoot at " + target;
	}

}
