package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * Base class for Actors in the Zombie World
 * @author ram
 *
 */
public abstract class ZombieActor extends Actor{


	protected ArrayList<Limb> items = new ArrayList<>();

	protected int turn = 0;



	public void setDisplayChar(char displayChar) {
		this.displayChar = displayChar;
	}

	/**
	 * returns the number of turns which a actor played
	 * @return turn
	 */
	@Override
	public int getNumTurn(){
		return turn;
	}

	/**
	 * returns the number of actor's Arms
	 * @return number of Arms
	 */
	@Override
	public int getNumArm() {
		int temp = 0;
		
		for(Limb i : items){
			if(i instanceof Arm){
				temp +=1;
			}
		}
		
		return temp;
	}

	/**
	 * returns number of Actor's leg
	 * @return number of legs
	 */
	@Override
	public int getNumLeg() {
		int temp = 0;
		
		for(Limb i : items){
			if(i instanceof Leg){
				temp +=1;
			}
		}
		
		return temp;
	}


	/**
	 *  this method creates 2 legs and 2 arms for an actor
	 * @param name actor name
	 * @param displayChar character of actor
	 * @param hitPoints hitpoint of actor
	 * @param team ZombieCapability of the actor
	 */
	public ZombieActor(String name, char displayChar, int hitPoints, ZombieCapability team) {
		super(name, displayChar, hitPoints);
		addCapability(team);

		items.add(new Leg("left leg", false));
		items.add(new Leg("right leg", false));

		items.add(new Arm("left arm", false));
		items.add(new Arm("right arm", false));
	}

	/**
	 * get all of the actions which includes crafting items from actor's inventory
	 *
	 * @return the actions which contains CraftAction
	 */
	public Actions hasCraftAction() {
		Actions actionsCraft = new Actions();
		for (Item i : this.getInventory()) {
			if (i.craftable()) {
				actionsCraft.add(new CraftAction(i));
			}
		}
		
		return actionsCraft;
	}
	
	public Actions addEatFoodAction() {
		Actions actions = new Actions();
		// Is there a Food item in my inventory?
		for (Item i : this.getInventory()) {
			if (i.asFood(i) != null) {
				actions.add(new EatFoodAction(i.asFood(i)));
			}
		}
		
		return actions;
	}
	
	public Actions addHarvestAction(GameMap map) {
		Actions actions = new Actions();
		List<Exit> actorExits = map.locationOf(this).getExits();
		List<Item> itemsOnActor = map.locationOf(this).getItems();
		boolean harvestActionAdded = false;
		
		// check if there are any ripe crop in actor's exits first.
		for (Exit e : actorExits) {
			List<Item> itemsOnLocation = e.getDestination().getItems();
			
			for (Item i : itemsOnLocation) {
				if (i.asCrop(i) != null && !harvestActionAdded) { // if i is a crop (ripe and unripe)
					if (i.asCrop(i).getIsRipe()) { // if i is a ripe crop
						actions.add(new HarvestAction(e.getDestination()));
						harvestActionAdded = true;
						return actions;
					}
				}
			}
		}
		
		// then check if actor is standing on any ripe crop.
		for (Item i : itemsOnActor) {
			if (i.asCrop(i) != null) {
				if (i.asCrop(i).getIsRipe() && !harvestActionAdded) {
					actions.add(new HarvestAction(map.locationOf(this)));
					harvestActionAdded = true;
					return actions;
				}
			}
		}
		
		return actions;
	}
	
	public Actions addRangeAttackAction(GameMap map) {
		Actions actions = new Actions();
		ArrayList<Actor> listOfTargets = new ArrayList<>();
		ArrayList<Ammo> listOfSniperRifleAmmo = new ArrayList<>();
		ArrayList<Ammo> listOfShotgunAmmo = new ArrayList<>();
		
		for (Item i : this.getInventory()) {
			if (i.asSniperRifleAmmo(i) != null) {
				listOfSniperRifleAmmo.add(i.asSniperRifleAmmo(i));
			}
		}
		
		for (Item i : this.getInventory()) {
			// code for SniperRifles
			SniperRifle sniper = i.asSniperRifle(i);
			if (sniper != null) {
				// set target for sniper rifles first
				for (int x = 0; x < 80; x++) {
					for (int y = 0; y < 25; y++) {
						if (map.at(x, y).getActor() != null && !map.at(x, y).getActor().equals(this)) {
							listOfTargets.add(map.at(x, y).getActor());
							break;
						}
					}
				}
				// if sniper has ammo, allow actor to choose to shoot or aim the sniper
				if (sniper.hasAmmo()) {
					for (Actor a : listOfTargets) {
						actions.add(new RangeAttackAction(a, sniper));
						// while sniper has less than 2 times aimed, it can be aimed again
						if (sniper.getAim() < 2) {
							actions.add(new AimAction(a, sniper));
						}
					}
				}
				// while actor has ammo in their inventory and there is no ammo in sniper, the actor can choose to reload
				if (listOfSniperRifleAmmo.size() > 0 && !sniper.hasAmmo()) {
					actions.add(new ReloadAction(sniper, listOfSniperRifleAmmo.get(0)));
				}
			}
			
			// code for Shotguns
			if (i.asShotgun(i) != null) {
				if (i.asShotgun(i).hasAmmo()) {
					// set target for shotguns first
					
				}
				
				if (i.asShotgun(i).hasAmmo()) {
					for (Actor a : listOfTargets) {
						actions.add(new RangeAttackAction(a, i.asShotgun(i)));
					}
				}
				
				if (listOfShotgunAmmo.size() > 0 && !i.asShotgun(i).hasAmmo()) {
					actions.add(new ReloadAction(i.asShotgun(i), listOfShotgunAmmo.get(0)));
				}
			}
			
			
		}
		
		return actions;		
	}

	@Override
	public Actions AllowableActions(GameMap map) {
		Actions actions = new Actions();
		
		if (this.crafter()) {
			actions.add(hasCraftAction());
		}
		
		if (this.harvester()) {
			actions.add(addHarvestAction(map));
		}
		
		if (this.personThatEatFood()) {
			actions.add(addEatFoodAction());
		}
		
		if (this.sheriff()) {
			actions.add(addRangeAttackAction(map));
		}
		
		return actions;
	}

	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions list = super.getAllowableActions(otherActor, direction, map);



		if ((otherActor.hasCapability(ZombieCapability.UNDEAD) != this.hasCapability(ZombieCapability.UNDEAD))) {


				list.add(new AttackAction(this));

			}


			return list;
		}

	}


