package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;

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
	
	public List<Action> getAllowableActions() {
		List<Action> actionList = new ArrayList<>();
		
		actionList.add(new SniperAimAction(this, 0));
		actionList.add(new SniperShootAction(this, 0));
		
		return actionList;
	}

	@Override
	public BulletType getBulletType() {
		return type;
	}
	
}
