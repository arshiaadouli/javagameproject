package game;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.interfaces.Crafter;
import edu.monash.fit2099.interfaces.Harvester;
import edu.monash.fit2099.interfaces.PersonThatEatFood;

import java.util.ArrayList;

/**
 * Class representing the Player.
 */
public class Player extends Human implements Crafter, Harvester, PersonThatEatFood {
	private Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
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

		turn++;

		System.out.println("player " + appearance);




		actions.add(super.AllowableActions(map));


		actions.add(new DieAction());





		if (lastAction.getNextAction() != null) {
			return lastAction.getNextAction();
		}
		
		return menu.showMenu(this, actions, display);
	}	

}
