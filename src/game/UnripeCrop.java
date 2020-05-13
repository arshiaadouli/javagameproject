package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class UnripeCrop extends Item {
	private int age = 0;

	public UnripeCrop(String name) {
		super(name, 'c', false); // 3rd parameter is false because UnripeCrop is always not portable.
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		age++;
		
		if (age == 20) {
			// remove UnripeCrop and add RipeCrop
		}
	}
}
