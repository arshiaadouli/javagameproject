package game;

import edu.monash.fit2099.engine.Location;

public class SniperRifle extends RangedWeapon {
	private static int num = 1;
	private int aim = 0;
	

	public SniperRifle() {
		super("Sniper Rifle " + num, '-', 45, "shoots");
	}
	
	public boolean hasAmmo() {		
		return !super.ammo.isEmpty();
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
	}

	@Override
	public void reload(Ammo ammo) {
		if (super.ammo.size() == 0) {
			super.ammo.add(ammo);
		}
	}
	
	@Override
	public void empty() {
		super.ammo.clear();
	}
	
	public void incAim() {
		if (this.aim < 2) {
			this.aim++;
		}
		
		if (this.aim == 1) {
			this.setDamage(this.damage() * 2);
		}
		if (this.aim == 2) {
			this.setDamage(1000);
		}
	}
	
	public int getAim() {
		return this.aim;
	}
	
	public void resetAim() {
		this.aim = 0;
	}
}
