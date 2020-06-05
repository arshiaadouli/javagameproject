package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.ActorLocations;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

public class SniperAimMenuAction extends Action {
	private List<Actor> targetList = new ArrayList<>();
	
	public SniperAimMenuAction() {
		
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		ActorLocations ai = new ActorLocations();
		while (ai.iterator().hasNext()) {
			targetList.add(ai.iterator().next());
		}
		return actor + " aimed at " + targetList;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " aim at " + targetList;
	}
	
	public Action aimMenu(Actor actor) {
		Menu menu = new Menu();
		Actions actions = new Actions();
		
		actions.add(new SniperShootAction(new SniperRifle()));
		
		return menu.showMenu(actor, actions, new Display());
	}

}
