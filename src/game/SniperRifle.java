package game;

import edu.monash.fit2099.engine.WeaponItem;

public class SniperRifle extends WeaponItem {

	public SniperRifle() {
		super("Sniper Rifle", '-', 45, "shoots");
	}
	
	@Override
	public boolean isRanged() {
		return true;
	}

}
