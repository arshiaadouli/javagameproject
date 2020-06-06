package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;

public class SniperRifle extends RangedWeapon {
	private static int num = 1;
	private BulletType type = BulletType.Sniper;
	private int aim = 0;
	private Actor aimTarget = null;

	public SniperRifle() {
		super("Sniper Rifle " + num, '-', 45, "shoots");
	}
	
	public boolean hasAmmo() {
		return !ammoList.isEmpty();
	}

	public void reload(Ammo ammo) {
		if (ammoList.size() == 0 && ammo != null) {
			ammoList.add(ammo);
		}
	}
	
	public void empty() {
		if (hasAmmo()) {
			ammoList.clear();
		}
	}
	
	public void incAim() {
		if (this.aim < 2) {
			this.aim++;
		}
	}
	
	public void resetAim() {
		this.aim = 0;
	}
	
	public int getAim() {
		return this.aim;
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
			actionList.add(new SniperShootAction(this));
			if (this.aim < 2) {
				actionList.add(new SniperAimAction(this));
			}
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
	
	public void setAimTarget(Actor target) {
		this.aimTarget = target;
	}
	
	public Actor getAimTarget() {
		return aimTarget;
	}
	
}
