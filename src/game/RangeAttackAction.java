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
		String retVal = actor + " " + weapon.verb() + " " + target + " for " + weapon.damage() + " damage";
		
		if (weapon.asSniperRifle(weapon).getAim() == 0 && rand.nextDouble() <= 0.75) {
			target.hurt(weapon.damage());
			weapon.empty();
		}
		else if (weapon.asSniperRifle(weapon).getAim() == 1 && rand.nextDouble() <= 0.9) {
			target.hurt(weapon.damage());
			weapon.empty();
		}
		else if (weapon.asSniperRifle(weapon).getAim() == 2) {
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
