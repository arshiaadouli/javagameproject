package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Crop extends Item {
	private int age = 0;
	private boolean isRipe = false;

	public Crop(String name) {
		super(name, 'c', false); // 3rd parameter is false because Crop is always starts as not portable.
		this.allowableActions.add(new FertilizeAction(this));
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		age++;
		
		if (age == 20) {
			displayChar = 'C';
			setIsRipe(true);
			this.allowableActions.add(new HarvestAction(location));
		}
	}
	
	// getters
	public boolean getIsRipe() {
		return isRipe;
	}
	
	// setters
	public void setIsRipe(boolean isRipe) {
		this.isRipe = isRipe;
	}
	
	//others
	public void fertilizeCrop() {
		this.age += 10;
	}
}