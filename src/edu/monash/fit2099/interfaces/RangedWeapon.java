package edu.monash.fit2099.interfaces;

import java.util.ArrayList;

import game.Ammo;

public interface RangedWeapon {
	ArrayList<Ammo> ammo = new ArrayList<>();
	
	public void reload(Ammo ammo);
}
