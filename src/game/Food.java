package game;

import edu.monash.fit2099.engine.Item;

public class Food extends Item {
	private int healsFor = 10;

	public Food(String name, char displayChar) {
		super(name, displayChar, true); // 3rd parameter is true because Food is always portable.
		this.allowableActions.add(new EatFoodAction(this));
	}
	
	public int getHealsFor() {
		return healsFor;
	}
}
