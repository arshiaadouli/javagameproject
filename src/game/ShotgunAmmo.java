package game;

/**
 * Class representing Shotgun Shell objects in the game.
 * @author Joseph Yu
 *
 */
public class ShotgunAmmo extends Ammo {
	private static int num = 1;
	private BulletType type = BulletType.Shotgun;
	
	public ShotgunAmmo() {
		super("Shotgun Ammo " + num, ']');
	}
	
	@Override
	public BulletType getBulletType() {
		return type;
	}

}
