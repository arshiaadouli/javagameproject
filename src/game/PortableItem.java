package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * Base class for any item that can be picked up and dropped.
 */
public class PortableItem extends Item {
	/**
	 * this class represents the corpse of Actors.
	 */
	private int age = 0;
	private static int humanCorpse = 0;
	private ZombieCapability zombieCapability = null;
	boolean aBoolean = false;

	public PortableItem(String name, char displayChar) {
		super(name, displayChar, true);


	}

	public static boolean getHumanCorpse(){
		return humanCorpse==0;
	}
	/**
	 * update the value of zombieCapability
	 * @param zc new Capability
	 */
	public void setZombieCap(ZombieCapability zc) {
		zombieCapability = zc;

	}

	/**
	 * if a non Zombie actor dies after 5 turns the corpse will be changed to the Zombie object
	 * however if the corpse is the corpse of the Zombie, nothing will happen after zombie's death
	 * @param currentLocation The location of the ground on which we lie.
	 */
	@Override
	public void tick(Location currentLocation) {
		super.tick(currentLocation);
		
		if (zombieCapability.equals(ZombieCapability.ALIVE)) {
			if(!aBoolean){
				humanCorpse+=1;
				aBoolean=true;
			}
			age += 1;

			
			if (age >= 5) {
				try {
					currentLocation.removeItem(this);
					currentLocation.addActor(new Zombie(name));
					humanCorpse -= 1;

					
				}
				catch (IllegalArgumentException e){
					System.out.println("actor in dead actor position");
				}
			}
		}
	}
}
