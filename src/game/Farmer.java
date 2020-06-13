package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.interfaces.Harvester;
import edu.monash.fit2099.interfaces.Consumer;
import edu.monash.fit2099.engine.DoNothingAction;

/**
 * Class representing a type of Human that can do everything a Human can, and more. It can sow crop onto a patch of dirt and fertilize crops around them.
 * @author Joseph Yu
 *
 */

public class Farmer extends Human implements Harvester, Consumer {
	static private ArrayList<Location> cropLocations = new ArrayList<Location>();
	static private ArrayList<Crop> cropObjs = new ArrayList<Crop>();
	private Behaviour[] behaviours = {
			new FertilizeBehaviour(this),
			new SowBehaviour(this),
			new HarvestBehaviour(),
			new EatFoodBehaviour(this),
			new WanderBehaviour()
	};
	
	/**
	 * Default constructor to create default farmers.
	 * @param name the farmer's display name.
	 */
	
	public Farmer(String name) {
		super(name);

	}
	
	/**
	 * Protected constructor can be used to create subtypes of farmers, such as different types of farmers that sow different types of crop that heals for different amount.
	 * @param name the farmer's display name.
	 * @param hitPoints amount of damage that the farmer can take before it dies.
	 */

	protected Farmer(String name, int hitPoints) {
		super(name, 'F', hitPoints);
		this.addCapability(ZombieCapability.ALIVE);

	}
	
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		this.addHarvestAction(map);
		
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			
			if (action != null) {
				return action;
			}
		}
		return new DoNothingAction();
	}
	
	/**
	 * Adds to 2 ArrayLists one containing location and another crop objects.
	 * @param l location object to add.
	 * @param c crop object to add.
	 * @throws Exception 
	 */
	
	public void addToCropLocations(Location location, Crop crop) throws Exception {
		if (location != null && crop != null) {
			cropLocations.add(location);
			cropObjs.add(crop);
		}
		else {
			throw new Exception("Location object and Crop object cannot be null");
		}
	}
	
	/**
	 * Method for outside classes to access all the location objects of the crop objects on the GameMap.
	 * @return ArrayList that contains all the location objects of the crop.
	 */
	
	public List<Location> getCropLocations() {
		return cropLocations;
	}
	
	/**
	 * Method for outside classes to access all the crop objects on the GameMap.
	 * @return ArrayList that contains all the crop objects.
	 */
	
	public List<Crop> getCropObjs() {
		return cropObjs;
	}

	@Override
	public boolean harvester() {
		return true;
	}
	
	@Override
	public boolean personThatEatFood() {
		return true;
	}
}
