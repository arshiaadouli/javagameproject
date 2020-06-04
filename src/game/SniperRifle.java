package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.interfaces.RangedWeapon;

public class SniperRifle extends RangedWeapon {
	private static int num = 1;
	private BulletType type = BulletType.Sniper;

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
	
	@Override
	public List<Action> getAllowableActions(Actor actor) {
		List<Action> actionList = new ArrayList<>();
		List<Ammo> ammoList = new ArrayList<>();
		
		for (Item i : actor.getInventory()) {
			if (i.asAmmo(i) != null) {
				ammoList.add(i.asAmmo(i));
			}
		}
		
		actionList.add(new SniperAimAction(this));
		actionList.add(new SniperShootAction(this));
		actionList.add(new ReloadAction(this, ammoList));
		
		return actionList;
	}

	@Override
	public BulletType getBulletType() {
		return type;
	}
	
}
