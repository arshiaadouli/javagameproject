package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.DoNothingAction;

public class Farmer extends Human {
	private List<Location> cropLocations;
	private List<Crop> cropObjs;
	private Behaviour[] behaviours = {
			new FertilizeBehaviour(this),
			new SowBehaviour(this),
			new HarvestBehaviour(this), 
			new EscapeBehaviour()
	};
	
	public Farmer(String name) {
		super(name);
	}

	protected Farmer(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}
	
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			if (action != null) {
				return action;
			}
		}
		return new DoNothingAction();
	}
	
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
	
	public void addToCropLocations(Location l, Crop c) {
		cropLocations.add(l);
		cropObjs.add(c);
	}
	
	// getters
	
	public Crop getCropObj(Location l) {
		List<Item> itemsOnLocation = l.getItems();
		
		for (Item i : itemsOnLocation) {
			for (Crop c : cropObjs) {
				if (i.equals(c)) {
					return c;
				}
			}
		}
		return null;
	}
	
	public List<Location> getCropLocations() {
		return cropLocations;
	}
	
	public List<Crop> getCropObjs() {
		return cropObjs;
	}
}
