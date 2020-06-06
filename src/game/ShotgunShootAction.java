package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

public class ShotgunShootAction extends Action {
	private Shotgun shotgun;
	private Random rand = new Random();
	
	public ShotgunShootAction(Shotgun shotgun) {
		this.shotgun = shotgun;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		double chance = 0.75;
		String retVal = "";
		Menu menu = new Menu();
		Display display = new Display();
		Actions actions = new Actions();
		ArrayList<Actor> targetList = new ArrayList<>();
		
		if (rand.nextDouble() <= chance) {
			shotgun.empty();
			actions.add(new ShotgunAimMenuAction(shotgun));
			retVal = menu.showMenu(actor, actions, display).execute(actor, map);
		}
		else {
			retVal = actor + " missed ";
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " shoots using " + shotgun;
	}

}
