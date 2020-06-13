package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Exit;
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
		HashMap<String, ArrayList<Integer>> direction = new HashMap<>();
		
		String id = "0";
		for (Exit e : map.locationOf(actor).getExits()) {
			ArrayList<Integer> temp = new ArrayList<>();
			
			temp.add(map.locationOf(actor).x() - e.getDestination().x());
			temp.add(map.locationOf(actor).y() - e.getDestination().y());
			direction.put(id, temp);
			id += "0";
		}
		
		
		shotgun.empty(); // action will consume 1 bullet even if it misses, that's why it's not included in the if statement body
		if (rand.nextDouble() <= chance) {			
			for (Entry<String, ArrayList<Integer>> ai: direction.entrySet()) {
				actions.add(new ShotgunAimMenuAction(shotgun, ai.getValue()));
			}
			
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
