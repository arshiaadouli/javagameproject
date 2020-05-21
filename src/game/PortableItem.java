package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * Base class for any item that can be picked up and dropped.
 */
public class PortableItem extends Item {

	int age = 0;
	ZombieCapability zombieCapability = null;

	public PortableItem(String name, char displayChar) {
		super(name, displayChar, true);
	}

	public void setZombieCap(ZombieCapability zc) {
		zombieCapability = zc;
	}

	@Override
	public void tick(Location currentLocation) {
		super.tick(currentLocation);
		
		if (zombieCapability.equals(ZombieCapability.ALIVE)) {
			age += 1;
			
			if (age >= 5) {
				try {
					currentLocation.removeItem(this);
					currentLocation.addActor(new Zombie(name));
				}
				catch (IllegalArgumentException e){
					System.out.println("actor in dead actor position");
				}
			}
		}
	}
}
