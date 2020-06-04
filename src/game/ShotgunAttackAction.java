package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.interfaces.RangedWeapon;

public class ShotgunAttackAction extends Action {
	private Actor target;
	private RangedWeapon weapon;
	private Random rand = new Random();
	
	public ShotgunAttackAction(Actor target, RangedWeapon weapon) {
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
