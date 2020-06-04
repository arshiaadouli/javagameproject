package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.interfaces.RangedWeapon;

public class SniperRifle extends RangedWeapon {
	private static int num = 1;

	public SniperRifle() {
		super("Sniper Rifle " + num, '-', 45, "shoots");
	}
	
	public boolean hasAmmo() {
		return !ammoList.isEmpty();
	}

	public void reload(Ammo ammo) {
		if (ammoList.size() == 0 && ammo != null) {
			ammoList.add(ammo);
		}
	}
	
	public void empty() {
		if (hasAmmo()) {
			ammoList.clear();
		}
	}
	
	public List<Action> getAllowableActions() {
		return null;
	}
	
}
