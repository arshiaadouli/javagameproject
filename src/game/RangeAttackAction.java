package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Weapon;

public class RangeAttackAction extends Action {
	private Actor target;
	
	public RangeAttackAction(Actor target) {
		this.target = target;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		Weapon weapon = actor.getWeapon();
		
		target.hurt(weapon.damage());
		
		return actor + " " + weapon.verb() + " " + target + " for " + weapon.damage() + " damage";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}

}
