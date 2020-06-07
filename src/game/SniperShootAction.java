package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SniperShootAction extends Action {
	private Actor target;
	private SniperRifle sniper;
	private Random rand = new Random();
	
	public SniperShootAction(SniperRifle sniper) {
		this.sniper = sniper;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		double chance = 0.75;
		String retVal = "";

		if (sniper.getAim() == 1) {
			chance = 0.9;
			sniper.setDamage(sniper.damage() * 2);
		}
		if (sniper.getAim() == 2) {
			chance = 1;
			sniper.setDamage(sniper.damage() * sniper.damage());
		}
		
		sniper.empty(); // action will consume 1 bullet even if it misses, that's why it's not included in the if statement body
		if (rand.nextDouble() <= chance) {
			actor.hurt(sniper.damage());
			retVal = actor + " sniped " + target + " for " + sniper.damage() + " damage";
		}
		else {
			retVal = actor + " missed " + target;
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " shoots using " + sniper;
	}

}
