package game;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.interfaces.Crafter;
import edu.monash.fit2099.interfaces.Harvester;
import edu.monash.fit2099.interfaces.PersonThatEatFood;

/**
 * Class representing the Player.
 */
public class Player extends Human implements Crafter, Harvester, PersonThatEatFood {
	private Menu menu = new Menu();
	private boolean wasHurt = false;

	public static int turns;


	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);

		turns=0;
	}

	@Override
	public boolean crafter() {
		return true;
	}

	@Override
	public boolean harvester() {
		return true;
	}

	@Override
	public boolean personThatEatFood() {
		return true;
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		turns+=1;
		turn+=1;

//		System.out.println(turn);
//		System.out.println(MamboMarie.mamboNum);
		System.out.println(MamboMarie.mamboNum);
		//		System.out.println(WorldSub.mamboNum);
		
		// adding RangedWeapon actions
		for (Item i : this.getInventory()) {
			if (i.asRangedWeapon(i) != null) {
				actions.add(i.asRangedWeapon(i).getAllowableAction(this));
			}
		}
		
		actions.add(super.AllowableActions(map));
		
		// ------------------ RESETTING SNIPER AIMING CODE ------------------
		if (lastAction.asSniperRifleAimAction(lastAction) == null) { // if lastAction IS NOT aiming
			for (Action a : actions) {
				if (a.asSniperRifleAimAction(a) != null) { // get the SniperRifleAimAction object
					a.asSniperRifleAimAction(a).getSniper().resetAim();
				}
			}
		}
		
		if (wasHurt) { // if player was hurt, reset aim
			for (Action a : actions) {
				if (a.asSniperRifleAimAction(a) != null) {
					a.asSniperRifleAimAction(a).getSniper().resetAim();
					wasHurt = false;
				}
			}
		}
		
		return menu.showMenu(this, actions, display);
	}
	
	@Override
	public void hurt(int points) {
		hitPoints -= points;
		wasHurt = true;
	}
}
