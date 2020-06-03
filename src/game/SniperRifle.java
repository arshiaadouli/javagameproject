package game;

import edu.monash.fit2099.engine.WeaponItem;
import edu.monash.fit2099.interfaces.RangedWeapon;

public class SniperRifle extends WeaponItem implements RangedWeapon {

	public SniperRifle() {
		super("Sniper Rifle", '-', 45, "shoots");
	}
	
	public boolean hasAmmo() {
		boolean retVal = false;
		
		if (ammo.size() > 0) {
			retVal = true;
		}
		
		return retVal;
	}

	@Override
	public void reload(Ammo ammo) {
		if (SniperRifle.ammo.size() == 0) {
			SniperRifle.ammo.add(ammo);
		}
	}
}
