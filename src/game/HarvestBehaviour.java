package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class HarvestBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Is there a RipeCrop on or around me?		
		List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		
		Location locationRipeCrop = null;
		
		for (Exit e : exits) {
			List<Item> itemsOnLocation = e.getDestination().getItems();
			for (Item i : itemsOnLocation) {
				if (i instanceof RipeCrop) {
					locationRipeCrop = e.getDestination();
				}
			}
		}
		
		List<Item> itemsOnActor = map.locationOf(actor).getItems();
		
		for (Item i : itemsOnActor) {
			if (i instanceof RipeCrop) {
				locationRipeCrop = map.locationOf(actor);
			}
		}
		
		return new HarvestAction(locationRipeCrop);
	}

}
