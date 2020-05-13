package game;

import edu.monash.fit2099.engine.Item;

public class RipeCrop extends Item {

	public RipeCrop(String name) {
		super(name, 'C', false); // 3rd parameter is false because RipeCrop is always not portable. Food objects are portable.
	}
}
