package game;

import edu.monash.fit2099.engine.Item;

public class PortableItemZombie extends Item {

	public PortableItemZombie(String name, char displayChar) {
		super(name, displayChar, true); // 3rd parameter is true because PortableItemZombie is always portable.
	}
}
