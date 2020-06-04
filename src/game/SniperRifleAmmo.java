package game;

public class SniperRifleAmmo extends Ammo {
	private static int num = 1;
	private BulletType type = BulletType.Sniper;
	
	public SniperRifleAmmo() {
		super("Sniper Rifle Ammo " + num, '[');
	}
	
	@Override
	public BulletType getBulletType() {
		return type;
	}

}
