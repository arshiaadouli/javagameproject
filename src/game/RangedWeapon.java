package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponItem;

public abstract class RangedWeapon extends WeaponItem {
	protected ArrayList<Ammo> ammoList = new ArrayList<>();
	protected int damage = super.damage();
	
	public RangedWeapon(String name, char displayChar, int damage, String verb) {
		super(name, displayChar, damage, verb);
	}

	public abstract void reload(Ammo ammo);
	
	public abstract void empty();
	
	public abstract BulletType getBulletType();
	
	// different to super's getAllowableActions() method
	public abstract List<Action> getAllowableAction(Actor actor);
	
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
