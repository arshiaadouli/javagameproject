package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ReloadAction extends Action {
	private RangedWeapon weapon;
	private Ammo ammo;
	
	public ReloadAction(RangedWeapon weapon, Ammo ammo) {
		this.weapon = weapon;
		this.ammo = ammo;
	}

	@Override
	public String execute(Actor actor, GameMap map) {

		weapon.reload(ammo);
		actor.removeItemFromInventory(ammo);
		
		return actor + " reloaded their " + weapon;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " reloads their " + weapon;
	}

}
