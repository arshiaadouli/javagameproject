package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Action class that reloads an Ammo object into a RangedWeapon's barrel.
 * @author Joseph Yu
 *
 */
public class ReloadAction extends Action {
	private RangedWeapon weapon;
	private List<Ammo> ammoList;
	
	public ReloadAction(RangedWeapon weapon, List<Ammo> ammoList) {
		this.weapon = weapon;
		this.ammoList = ammoList;
	}
	
	/**
	 * This method checks whether the ammo object is compatible to be loaded into a RangedWeapon.
	 * @param weapon The RangedWeapon object to check whether it is compatible with the Ammo object.
	 * @param ammo The Ammo object to check whether it is compatible with the RangedWeapon object.
	 * @return true or false.
	 */
	public boolean compatible(RangedWeapon weapon, Ammo ammo) {
		boolean retVal = false;
		
		if (weapon.getBulletType().compareTo(ammo.getBulletType()) == 0) {
			retVal = true;
		}
		
		return retVal;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		for(Ammo a : this.ammoList) {
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
