package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SniperAttackAction extends Action {
	private Actor target;
	private RangedWeapon weapon;
	private Random rand = new Random();
	
	public SniperAttackAction(Actor target, RangedWeapon weapon) {
		this.target = target;
		this.weapon = weapon;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " " + weapon.verb() + " " + target + " for " + weapon.damage() + " damage";
		double chance = 0.75;
		
		if (weapon.asSniperRifle(weapon).getAim() == 0) {
			chance = 0.75;
		}
		else if (weapon.asSniperRifle(weapon).getAim() == 1) {
			chance = 0.9;
		}
		else if (weapon.asSniperRifle(weapon).getAim() == 2) {
			chance = 1;
		}
		
		if (rand.nextDouble() <= chance) {
			target.hurt(weapon.damage());
			weapon.empty();
		}
		else {
			retVal = actor + " missed " + target;
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " shoots " + target;
	}

}
