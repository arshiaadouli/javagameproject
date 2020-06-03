package game;

import edu.monash.fit2099.engine.WeaponItem;
import edu.monash.fit2099.interfaces.RangedWeapon;

public class Shotgun extends WeaponItem implements RangedWeapon {

	public Shotgun(String name) {
		super(name, '=', 10, "shoots");
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
		Shotgun.ammo.add(ammo);	
	}

}
