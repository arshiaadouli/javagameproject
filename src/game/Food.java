package game;

import edu.monash.fit2099.engine.Item;

/**
 * Class representing food that can be eaten by humans.
 * @author Joseph Yu
 *
 */

public class Food extends Item {
	/**
	 * Number of heal points each food object heals for.
	 */
	private int healsFor = 10;

	/**
	 * 
	 * @param name the food's display name.
	 */
	
	public Food(String name) {
		super(name, 'f', true); // 3rd parameter is true because Food is always portable.
		this.allowableActions.add(new EatFoodAction(this));
	}
	
	/**
	 * Method for outside class to get how many health points the food object will restore.
	 * @return integer that represents how many points the food object will heal the human that eats it for.
	 */
	
	public int getHealsFor() {
		return healsFor;
	}
}
