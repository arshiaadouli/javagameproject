package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.WeaponItem;

public abstract class RangedWeapon extends WeaponItem {
	protected ArrayList<Ammo> ammoList = new ArrayList<>();
	protected int damage = 0;
	
	public RangedWeapon(String name, char displayChar, int damage, String verb) {
		super(name, displayChar, damage, verb);
	}

	public abstract void reload(Ammo ammo);
	
	public abstract void empty();
	
	public abstract BulletType getBulletType();
	
	@Override
	public abstract List<Action> getAllowableActions();
	
	@Override
	public int damage() {
		return this.damage;
	}
	
	public void setDamage(int damage) {
		if (damage > 0) {
			this.damage = damage;
		}
	}
	
}
