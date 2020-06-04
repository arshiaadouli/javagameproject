package game;

import edu.monash.fit2099.engine.Item;

public class Ammo extends Item {

	public Ammo(String name, char displayChar) {
		super(name, displayChar, true);
	}
	
	public BulletType getBulletType() {
		// override this method to return your own bullet type e.g. "arrow"
		// remember to add "arrow" type to BulletType enum class as well
		return null;
	}
	
}
