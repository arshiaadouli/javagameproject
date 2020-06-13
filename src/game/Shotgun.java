package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;

/**
 * Class represent a Shotgun object in the game.
 * @author Joseph Yu
 *
 */
public class Shotgun extends RangedWeapon {
	private static int num = 1;
	private BulletType type = BulletType.Shotgun;
	
	/**
	 * Initializes barrel size of a shotgun.
	 */
	public Shotgun() {
		super("Shotgun " + num, '=', 20, "shoots");
		setBarrelSize(2);
	}
	
	/**
	 * Loads an ammo object into the shotgun.
	 * @param ammo Ammo object to be loaded into the Shotgun object.
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
	 * Adds all the actions that a Player can perform when they have a shotgun in their inventory 
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
			actionList.add(new ShotgunShootAction(this));
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

	@Override
	public int getMeleeDamage() {
		setVerb("hits");
		return 10;
	}
	
	/**
	 * Resets the damage of a shotgun hit to base damage: 20
	 */
	public void resetDamage() {
		this.setDamage(20);
	}

}
