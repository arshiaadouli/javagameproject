package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.interfaces.RangedWeapon;

public class Shotgun extends RangedWeapon {
	private static int num = 1;

	public Shotgun() {
		super("Shotgun " + num, '=', 10, "shoots");
	}
	
	public boolean hasAmmo() {		
		return !ammoList.isEmpty();
	}

	public void reload(Ammo ammo) {
		if (ammoList.size() < 2 && ammo != null) {
			ammoList.add(ammo);
		}
	}
	
	public void empty() {
		if (hasAmmo()) {
			ammoList.remove(0);
		}
	}
	
	public List<Action> getAllowableActions() {
		return null;
	}

}
