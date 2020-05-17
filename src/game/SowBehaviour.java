package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;

public class SowBehaviour implements Behaviour {
	private Farmer f;
	
	public SowBehaviour(Farmer f) {
		this.f = f;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {		
		List<Exit> exits = map.locationOf(actor).getExits();
		ArrayList<Exit> exitsAvailable = new ArrayList<Exit>();
		Crop c = new Crop(actor.toString());
		
		for (Exit e : exits) {
			if (e.getDestination().canActorEnter(actor)) {
				exitsAvailable.add(e);
			}
		}
		
		if (exitsAvailable.size() > 0) {
			Collections.shuffle(exitsAvailable);
			return new SowAction(exitsAvailable.get(0).getDestination(), f, c);
		}
		return null;
	}
}
