package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;

public class SowBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there a patch of dirt near me?
		boolean atLeastOneAvailable = false; // Fail-Fast OOP principle
		
		List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		
		for (Exit e : exits) {
			if (e.getDestination().getDisplayChar() == '.') {
				atLeastOneAvailable = true;
			}
		}
		
		if (atLeastOneAvailable) {
			Collections.shuffle(exits);
			return new SowAction(exits.get(0));
		}
		return null;
	}
}
