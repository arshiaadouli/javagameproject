package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;

/**
 * Class represent a SniperRifle object in the game.
 * @author Joseph Yu
 *
 */
public class SniperRifle extends RangedWeapon {
	private static int num = 1;
	private BulletType type = BulletType.Sniper;
	private int aim = 0;
	private Actor aimTarget = null;
	private Actor shootTarget = null;
	
	/**
	 * Initializes barrel size of a shotgun.
	 */
	public SniperRifle() {
		super("Sniper Rifle " + num, '-', 45, "shoots");
		setBarrelSize(1);
	}
	
	/**
	 * Loads an ammo object into the shotgun.
	 * @param ammo Ammo object to be loaded into the SniperRifle object.
	 */
	public void reload(Ammo ammo) {
		if (ammoList.size() < barrelSize && ammo != null) {
			ammoList.add(ammo);
		}
	}
	
	/**
	 * Removes 1 ammo object in the shotgun.
	 */
	public void empty() {
		if (hasAmmo()) {
			ammoList.remove(0);
		}
	}
	
	/**
	 * Increments the aim of the sniper by 1
	 */
	public void incAim() {
		if (this.aim < 2) {
			this.aim++;
		}
	}
	
	/**
	 * Resets the aim of the sniper
	 */
	public void resetAim() {
		this.aim = 0;
	}
	
	/**
	 * @return Aim of the sniper.
	 */
	public int getAim() {
		return this.aim;
	}
	
	/**
	 * Adds all the actions that a Player can perform when they have a sniper rifle in their inventory 
	 */
	public List<Action> getAllowableAction(Actor actor) {
		List<Action> actionList = new ArrayList<>();
		List<Ammo> ammoList = new ArrayList<>();
		ReloadAction reloadAction = new ReloadAction(this, ammoList);
		
		for (Item i : actor.getInventory()) {
			if (i.asAmmo(i) != null) {
				ammoList.add(i.asAmmo(i));
			}
		}
		
		if (this.hasAmmo()) {
			actionList.add(new SniperRifleShootAction(this));
			if (this.aim <= 2) {
				actionList.add(new SniperRifleAimAction(this));
			}
		}
		
		if (ammoList.size() > 0) {
			for (Ammo a : ammoList) {
				if (reloadAction.compatible(this, a)) {
					actionList.add(reloadAction);
				}
			}
		}
		
		return actionList;
	}

	@Override
	public BulletType getBulletType() {
		return type;
	}
	
	/**
	 * Sets the aim target of the sniper
	 * @param target Actor that the sniper is aiming at.
	 */
	public void setAimTarget(Actor target) {
		this.aimTarget = target;
	}
	
	/**
	 * @return Aim target of the sniper
	 */
	public Actor getAimTarget() {
		return aimTarget;
	}
	
	/**
	 * Sets the shoot target of the sniper
	 * @param target Actor that the sniper is shooting at.
	 */
	public void setShootTarget(Actor target) {
		this.shootTarget = target;
	}
	
	/**
	 * @return Shoot target of the sniper
	 */
	public Actor getShootTarget() {
		return shootTarget;
	}

	@Override
	public int getMeleeDamage() {
		setVerb("hits");
		return 10;
	}
	 /**
	  * Sets the damage accordingly to the current aim
	  */
	@Override
	public int damage() {
		if (this.aim == 1) {
			return 45 * 2;
		}
		else if (this.aim == 2) {
			return 1999999999;
		}
		
		return 45;
	}
	
}
