package game;

import java.util.List;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Crop extends Item {
	private int age = 0;
	private boolean isRipe = false;
	private static List<Location> cropLocations;

	public Crop(String name) {
		super(name, 'c', false); // 3rd parameter is false because Crop is always starts as not portable.
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		age++;
		
		if (age == 20) {
			displayChar = 'C';
			setIsRipe(true);
		}
	}
	
	// getters
	public boolean getIsRipe() {
		return isRipe;
	}
	
	public List<Location> getCropLocations() {
		return cropLocations;
	}
	
	// setters
	public void setIsRipe(boolean isRipe) {
		this.isRipe = isRipe;
	}
	
	public void addToCropLocationsList(Location l) {
		cropLocations.add(l);
	}
	
	// others
	public boolean isInCropLocations(Location l) {
		boolean retVal = false;
		for (Location cropLocation : cropLocations) {
			if (cropLocation.x() == l.x() && cropLocation.y() == l.y()) {
				retVal = true;
				break;
			}
		}
		
		return retVal;
	}
}