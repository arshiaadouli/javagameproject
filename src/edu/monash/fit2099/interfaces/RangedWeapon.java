package edu.monash.fit2099.interfaces;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponItem;
import game.Ammo;
import game.BulletType;

public abstract class RangedWeapon extends WeaponItem {
	protected ArrayList<Ammo> ammoList = new ArrayList<>();
	protected int damage = 0;
	
	public RangedWeapon(String name, char displayChar, int damage, String verb) {
		super(name, displayChar, damage, verb);
	}

	public abstract void reload(Ammo ammo);
	
	public abstract void empty();
	
	public abstract BulletType getBulletType();
	
	public abstract List<Action> getAllowableActions(Actor actor);
	
	public boolean compatible(RangedWeapon weapon, Ammo ammo) {
		boolean retVal = false;
		
		if (weapon.getBulletType().compareTo(ammo.getBulletType()) == 0) {
			retVal = true;
		}
		
		return retVal;
	}
	
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
