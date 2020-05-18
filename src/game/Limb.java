package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public interface Limb {

	public int craft(Actor actor, Item item, GameMap map);
}
