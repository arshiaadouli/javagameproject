package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

public class RangedWeapon extends Item implements Weapon {
	protected ArrayList<Ammo> ammo = new ArrayList<>();
	private int damage = 0;
	private String verb;
	
	public RangedWeapon(String name, char displayChar, int damage, String verb) {
		super(name, displayChar, true);
		this.damage = damage;
		this.verb = verb;
	}
	
	public void reload(Ammo ammo) {
		// Override this method in your specific ranged weapon classes
	}
	
	public void empty() {
		// Override this method in your specific ranged weapon classes
	}
	
	public void setDamage(int damage) {
		if (damage >= 0) {
			this.damage = damage;
		}
	}

	@Override
	public int damage() {
		return damage;
	}

	@Override
	public String verb() {
		return verb;
	}
	
}
