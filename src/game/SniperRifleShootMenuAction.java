package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SniperRifleShootMenuAction extends Action {
	private Actor target;
	private SniperRifle sniper;
	private Random rand = new Random();
	
	public SniperRifleShootMenuAction(Actor target, SniperRifle sniper) {
		this.target = target;
		this.sniper = sniper;
		sniper.setShootTarget(target);
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		double chance = 0.75;
		
		if (sniper.getAim() == 1) {
			chance = 0.9;
		}
		if (sniper.getAim() == 2) {
			chance = 1;
		}
		
		sniper.empty(); // action will consume 1 bullet even if it misses, that's why it's not included in the if statement body
		if (rand.nextDouble() <= chance) {
			if (sniper.getAim() == 0) {
				target.hurt(sniper.damage());
				return actor + " shoots " + target + " for " + sniper.damage() + " damage";
			}
			else if (sniper.getAimTarget().equals(target)) {
				target.hurt(sniper.damage());
				return actor + " shoots " + target + " for " + sniper.damage() + " damage";
			}
			else {
				sniper.resetAim();
				target.hurt(sniper.damage());
				return actor + " shoots " + target + " for " + sniper.damage() + " damage";
			}
		}
		
		return actor + " missed " + target;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " shoot at " + target;
	}

}
