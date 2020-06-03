package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class RangeAttackAction extends Action {
	private Actor target;
	private RangedWeapon weapon;
	private Random rand = new Random();
	
	public RangeAttackAction(Actor target, RangedWeapon weapon) {
		this.target = target;
		this.weapon = weapon;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		SniperRifle sniper = weapon.asSniperRifle(weapon);
		
		if (sniper != null) {
			if (sniper.getAim() == 0) {
				if (rand.nextDouble() <= 0.75) {
					target.hurt(sniper.damage());
				}
			}
			if (sniper.getAim() == 1) {
				if (rand.nextDouble() <= 0.9) {
					target.hurt(sniper.damage() * 2);
				}
			}
			if (sniper.getAim() == 2) {
				target.hurt(1000);
			}
		}
		else {
			target.hurt(weapon.damage());
		}
		weapon.empty();
		
		return actor + " " + weapon.verb() + " " + target + " for " + weapon.damage() + " damage";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " shoots " + target;
	}

}
