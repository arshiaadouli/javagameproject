package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ShotgunShootAction extends Action {
	private Actor target;
	private RangedWeapon weapon;
	private Random rand = new Random();
	
	public ShotgunShootAction() {
		
	}

	@Override
	public String execute(Actor actor, GameMap map) {		
		return actor + " shotgunned " + target;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " shotguns " + target;
	}

}
