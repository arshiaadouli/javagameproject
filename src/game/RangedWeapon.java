package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.WeaponItem;

public class RangedWeapon extends WeaponItem {
	protected ArrayList<Ammo> ammo = new ArrayList<>();
	
	public RangedWeapon(String name, char displayChar, int damage, String verb) {
		super(name, displayChar, damage, verb);
	}
	
	public void reload(Ammo ammo) {
		// Override this method in your specific ranged weapon classes
	}
	
	public void empty() {
		// Override this method in your specific ranged weapon classes
	}
	
}
