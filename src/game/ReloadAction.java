package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ReloadAction extends Action {
	private RangedWeapon weapon;
	private List<Ammo> ammo;
	
	public ReloadAction(RangedWeapon weapon, List<Ammo> ammo) {
		this.weapon = weapon;
		this.ammo = ammo;
	}
	
	public boolean compatible(RangedWeapon weapon, Ammo ammo) {
		boolean retVal = false;
		
		if (weapon.getBulletType().compareTo(ammo.getBulletType()) == 0) {
			retVal = true;
		}
		
		return retVal;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		
		for(Ammo a : this.ammo) {
			if (compatible(weapon, a)) {
				weapon.reload(a);
				actor.removeItemFromInventory(a);
			}
		}
		
		return actor + " reloaded their " + weapon;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " reloads their " + weapon;
	}

}
