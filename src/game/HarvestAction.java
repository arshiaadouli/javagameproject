package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class HarvestAction extends Action {
	private Exit e;
	
	public HarvestAction(Exit e) {
		this.e = e;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = "";
		List<Exit> exits = e.getDestination().getExits();
		
		for (Exit e : exits) {
			if (e.getDestination().getDisplayChar() == 'C') { // if true add food to inventory and change displayChar to '.'
				actor.addItemToInventory(new Food("Food", 'F'));
				
				for (Item i : e.getDestination().getItems()) {
					if (i.getDisplayChar() == 'C') {
						e.getDestination().removeItem(i);
					}
				}
			}
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " harvests a Ripe Crop nearby.";
	}
}
