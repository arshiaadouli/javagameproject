package game;

public class SniperRifle extends RangedWeapon {
	private static int num = 1;

	public SniperRifle() {
		super("Sniper Rifle " + num, '-', 45, "shoots");
	}
	
	public boolean hasAmmo() {
		boolean retVal = false;
		
		if (ammo.size() > 0) {
			retVal = true;
		}
		
		return retVal;
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
}
