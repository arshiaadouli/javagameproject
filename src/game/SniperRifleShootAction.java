package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

/**
 * Action class that gets all the actors x and y coordinates on the GameMap and passes them onto a SniperRifleShootMenuAction object.
 * @author Joseph Yu
 *
 */
public class SniperRifleShootAction extends Action {
	private SniperRifle sniper;
	
	public SniperRifleShootAction(SniperRifle sniper) {
		this.sniper = sniper;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		Menu menu = new Menu();
		Display display = new Display();
		Actions actions = new Actions();
		ArrayList<Actor> targetList = new ArrayList<>();
		
		// add all actors in current GameMap
		for (int x = 0; x < 80; x++) {
			for (int y = 0; y < 25; y++) {
				if (!map.at(x, y).equals(map.locationOf(actor)) && map.at(x, y).getActor() != null) {
					targetList.add(map.at(x, y).getActor());
				}
			}
		}
		
		// add aim options for each target
		for (Actor a : targetList) {
			actions.add(new SniperRifleShootMenuAction(a, sniper));
		}
		
		return menu.showMenu(actor, actions, display).execute(actor, map);
		
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " shoots using " + sniper;
	}

}
