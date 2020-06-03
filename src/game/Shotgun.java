package game;

public class Shotgun extends RangedWeapon {
	private static int num = 1;

	public Shotgun() {
		super("Shotgun " + num, '=', 10, "shoots");
	}
	
	public boolean hasAmmo() {		
		return !super.ammo.isEmpty();
	}

	@Override
	public void reload(Ammo ammo) {
			
	}
	
	@Override
	public void empty() {
		
	}

}
