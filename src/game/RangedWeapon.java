package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * Class representing Ranged Weapons
 * @author Joseph Yu
 *
 */
public abstract class RangedWeapon extends WeaponItem {
	protected ArrayList<Ammo> ammoList = new ArrayList<>();
	protected int damage = super.damage();
	protected String verb = super.verb();
	protected int barrelSize = 0;
	
	public RangedWeapon(String name, char displayChar, int damage, String verb) {
		super(name, displayChar, damage, verb);
	}
	
	/**
	 * Every RangedWeapon has to be able to reload. Infinite ammo can also be implemented through this method.
	 * @param ammo Ammo object to be loaded into the RangedWeapon
	 */
	public abstract void reload(Ammo ammo);
	
	/**
	 * If every RangedWeapon can be reloaded, they can be emptied too.
	 */
	public abstract void empty();
	
	/**
	 * RangedWeapons reload bullets and this method can return the RangedWeapon's bulletType which is an enum.
	 * @return enum BulletType.
	 */
	public abstract BulletType getBulletType();
	
	/**
	 * For using in melee ranged.
	 * @return Number of damage when the RangedWeapon is used in melee range.
	 */
	public abstract int getMeleeDamage();
	
	/**
	 * This method returns all the allowable actions of the RangedWeapon.
	 * @param actor Actor that is performing the actions.
	 * @return List containing Action objects that the RangedWeapon can allow the Player to perform.
	 */
	// different to super's getAllowableActions() method
	public abstract List<Action> getAllowableAction(Actor actor);
	
	@Override
	public int damage() {
		return this.damage;
	}
	
	@Override
	public String verb() {
		return this.verb;
	}
	
	/**
	 * This method changes the damage of the RangedWeapon.
	 * @param damage Damage of the RangedWeapon.
	 */
	public void setDamage(int damage) {
		if (damage > 0) {
			this.damage = damage;
		}
	}
	
	/**
	 * This method changes the verb of the RangedWeapon. E.g. switching from melee to ranged have different verbs.
	 * @param verb e.g. "punches", "shoots"
	 */
	public void setVerb(String verb) {
		if (verb.length() > 0) {
			this.verb = verb;
		}
	}
	
	/**
	 * This method checks whether the RangedWeapon has at least 1 ammo object loaded.
	 * @return true or false
	 */
	public boolean hasAmmo() {
		return !ammoList.isEmpty();
	}
	
	/**
	 * This method sets the size of the RangedWeapon.
	 * @param size Number of Ammo objects the RangedWeapon can hold in its barrel.
	 */
	public void setBarrelSize(int size) {
		if (size > 0) {
			barrelSize = size;
		}
	}
	
}
