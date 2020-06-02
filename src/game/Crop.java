package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * Crops that start of as unripe and once it ripes it can be harvested by humans/the player
 * 
 * @author Joseph Yu
 *
 */

public class Crop extends Item {
	private int age = 0;
	private boolean isRipe = false;
	private FertilizeAction f = new FertilizeAction(this);

	public Crop(String name) {
		super(name, 'c', false); // 3rd parameter is false because Crop is never portable.
		this.allowableActions.add(this.f);
	}
	
	/**
	 * Calls the super's tick function and checks if the age is greater than or equals to 20 and if so, change displayChar and setIsRipe to true.
	 */
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		age++;
		
		if (age >= 20) {
			displayChar = 'C';
			setIsRipe(true);
		}
	}
	
	/**
	 * Method for outside classes to determine whether a crop around them is ready to be harvested or not.
	 * @return isRipe boolean variable that lets outside classes know if the crop object is ripe or not.
	 */
	
	// getters
	public boolean getIsRipe() {
		return isRipe;
	}
	
	/**
	 * Method for outside classes to change the class variable isRipe.
	 * @param isRipe boolean variable that represent whether the crop object is ripe or not.
	 */
	
	// setters
	public void setIsRipe(boolean isRipe) {
		this.isRipe = isRipe;
	}
	
	/**
	 * Method for outside classes to fertilize the crop object, which increases the age of the crop and removes the fertilize action once the crop is ripe.
	 */
	
	//others
	public void fertilizeCrop() {
		this.age += 10;
		
		if (this.age >= 20) { // crop can't be fertilized anymore after it's ripe
			this.allowableActions.remove(this.f);
		}
	}
}