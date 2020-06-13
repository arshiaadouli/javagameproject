package game;

/**
 * Class representing Sniper Rifle Ammo objects in the game.
 * @author Joseph Yu
 *
 */
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
