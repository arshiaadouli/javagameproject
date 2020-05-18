package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Crop extends Item {
	private int age = 0;
	private boolean isRipe = false;
	private HarvestAction h = null;
	private FertilizeAction f = new FertilizeAction(this);

	public Crop(String name) {
		super(name, 'c', false); // 3rd parameter is false because Crop is never portable.
		this.allowableActions.add(this.f);
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		age++;
		
		if (age >= 20) {
			displayChar = 'C';
			setIsRipe(true);
			
			if (h == null) {
				h = new HarvestAction(location);
				this.allowableActions.add(h);
			}
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
		
		if (this.age >= 20) { // crop can't be fertilized anymore after it's ripe
			this.allowableActions.remove(this.f);
		}
	}
}