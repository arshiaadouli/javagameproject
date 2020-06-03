package game;

public class Shotgun extends RangedWeapon {
	private static int num = 1;

	public Shotgun() {
		super("Shotgun " + num, '=', 10, "shoots");
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
			
	}

}
