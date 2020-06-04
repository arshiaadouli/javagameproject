package edu.monash.fit2099.interfaces;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.WeaponItem;
import game.Ammo;

public abstract class RangedWeapon extends WeaponItem {
	protected ArrayList<Ammo> ammoList = new ArrayList<>();
	
	public RangedWeapon(String name, char displayChar, int damage, String verb) {
		super(name, displayChar, damage, verb);
	}

	public abstract void reload(Ammo ammo);
	
	public abstract void empty();
	
	@Override
	public abstract List<Action> getAllowableActions();
}
