package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;

public class Shotgun extends RangedWeapon {
	private static int num = 1;
	private BulletType type = BulletType.Shotgun;

	public Shotgun() {
		super("Shotgun " + num, '=', 10, "shoots");
	}
	
	public boolean hasAmmo() {		
		return !ammoList.isEmpty();
	}

	public void reload(Ammo ammo) {
		if (ammoList.size() < 2 && ammo != null) {
			ammoList.add(ammo);
		}
	}
	
	public void empty() {
		if (hasAmmo()) {
			ammoList.remove(0);
		}
	}

	public List<Action> getAllowableActions() {
		List<Action> actionList = new ArrayList<>();
		
		actionList.add(new ShotgunShootAction());
		
		return actionList;
	}

	@Override
	public BulletType getBulletType() {
		return type;
	}

}
