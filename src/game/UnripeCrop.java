package game;

import edu.monash.fit2099.engine.Item;

public class UnripeCrop extends Item {

	public UnripeCrop(String name, char displayChar) {
		super(name, displayChar, false); // 3rd parameter is false because UnripeCrop is always not portable.
	}
}
