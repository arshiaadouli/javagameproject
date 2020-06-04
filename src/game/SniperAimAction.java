package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

public class SniperAimAction extends Action {
	private Actor target;
	private SniperRifle sniper;
	private int aim = 0;
	private Actor actor;
	private GameMap map;
	
	public SniperAimAction(SniperRifle sniper, int aim) {
		this.sniper = sniper;
		this.aim = aim;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		this.actor = actor;
		this.map = map;
		return actor + " aimed at " + target;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " aims using " + sniper;
	}
	
	public void incAim() {
		if (aim < 2) {
			aim++;
		}
	}
	
	@Override
	public Action getNextAction() {
		Display display = new Display();
		Actions actions = new Actions();
		
		actions.add(this);
		
		return new Menu().showMenu(actor, actions, display);
	}

}
