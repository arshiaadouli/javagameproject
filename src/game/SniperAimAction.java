package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.ActorLocations;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

public class SniperAimAction extends Action {
	private SniperRifle sniper;

	public SniperAimAction(SniperRifle sniper) {
		this.sniper = sniper;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		sniper.incAim();
		Menu menu = new Menu();
		Display display = new Display();
		Actions actions = new Actions();
		ActorLocations actorLocations = new ActorLocations();
		ArrayList<Actor> targetList = new ArrayList<>();
		
		targetList.add(actorLocations.iterator().next());
		
		for (Actor a : targetList) {
			actions.add(new SniperAimMenuAction(a));
		}
		
		
		return menu.showMenu(actor, actions, display).execute(actor, map);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " aims using " + sniper;
	}

	public SniperRifle getSniper() {
		return sniper;
	}

}
