package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class RangeAttackAction extends Action {
	private Actor target;
	
	public RangeAttackAction(Actor target) {
		this.target = target;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		RangedWeapon weapon = null;
		
		for (Item i : actor.getInventory()) {
			if (i.asRangedWeapon(i) != null) {
				weapon = i.asRangedWeapon(i);
				actor.hurt(weapon.damage());
				weapon.empty();
			}
		}
		
		return actor + " " + weapon.verb() + " " + target + " for " + weapon.damage() + " damage";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " shoots " + target;
	}

}
