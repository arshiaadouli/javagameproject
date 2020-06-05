package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SniperShootAction extends Action {
	private Actor target;
	private SniperRifle sniper;
	private Random rand = new Random();
	private int aim = 0;
	
	public SniperShootAction(SniperRifle sniper) {
		this.sniper = sniper;
		this.aim = sniper.getAim();
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		double chance = 0.75;
		
		if (aim == 1) {
			chance = 0.9;
			sniper.setDamage(sniper.damage() * 2);
		}
		if (aim == 2) {
			chance = 1;
			sniper.setDamage(sniper.damage() * sniper.damage());
		}
		
		if (rand.nextDouble() <= chance) {
			sniper.empty();
			actor.hurt(sniper.damage());
		}
		
		return actor + " sniped " + target;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " shoots using " + sniper;
	}

}
