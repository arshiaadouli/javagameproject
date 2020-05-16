package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.DoNothingAction;

public class Farmer extends Human {
	static private ArrayList<Location> cropLocations = new ArrayList<Location>();
	static private ArrayList<Location> ripeCropLocations = new ArrayList<Location>();
	static private ArrayList<Crop> cropObjs = new ArrayList<Crop>();
	static private ArrayList<Crop> ripeCropObjs = new ArrayList<Crop>();
	private Crop c = new Crop(this.name);
	private Behaviour[] behaviours = {
			new FertilizeBehaviour(this),
			new SowBehaviour(this, c),
			new HarvestBehaviour(cropLocations),
			new EatFoodBehaviour(this), 
			new WanderBehaviour()
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
	
	public void addToCropLocations(Location l, Crop c) {
		cropLocations.add(l);
		cropObjs.add(c);
	}
	
	// getters
	
	public List<Location> getCropLocations() {
		return cropLocations;
	}
	
	public List<Location> getRipeCropLocations() {
		for (int i = 0; i < cropLocations.size(); i++) {
			if (cropObjs.get(i).getIsRipe()) {
				ripeCropLocations.add(cropLocations.get(i));
			}
		}
		return ripeCropLocations;
	}
	
	public List<Crop> getCropObjs() {
		return cropObjs;
	}
}
