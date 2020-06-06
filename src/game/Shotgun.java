package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;

public class Shotgun extends RangedWeapon {
	private static int num = 1;
	private BulletType type = BulletType.Shotgun;

	public Shotgun() {
		super("Shotgun " + num, '=', 10, "shoots");
		setBarrelSize(2);
	}

	public void reload(Ammo ammo) {
		if (ammoList.size() < barrelSize && ammo != null) {
			ammoList.add(ammo);
		}
	}
	
	public void empty() {
		if (hasAmmo()) {
			ammoList.remove(0);
		}
	}

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
		else if (ammoList.size() > 0) {
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
		return 10;
	}

}
