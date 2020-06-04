package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.interfaces.RangedWeapon;

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
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return null;
	}

}
