package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;
	/**
	 * Random number generator
	 */
	protected Random rand = new Random();

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 */
	public AttackAction(Actor target) {
		this.target = target;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		Weapon weapon = actor.getWeapon();
		int damage = weapon.damage();
		
		if (rand.nextBoolean()) {
			return actor + " misses " + target + ".";
		}

		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage";

		target.hurt(damage);


		if(actor instanceof Zombie && weapon.verb().equals("bites")){
			actor.heal(5);

		}
		
		if (!target.isConscious()) {
			PortableItem corpse = null;

			if (target.hasCapability(ZombieCapability.ALIVE)) {
				corpse = new PortableItem("dead " + target, '%');
				Actions dropActions = new Actions();

				for (Item item : target.getInventory())
					dropActions.add(item.getDropAction());

				for (Action drop : dropActions)
					drop.execute(target, map);

				map.locationOf(target).addItem(corpse);
				corpse.setZombieCap(ZombieCapability.ALIVE);
			}
			else {
				corpse = new PortableItem("dead " + target, '%');
				Actions dropActions = new Actions();

				for (Item item : target.getInventory())
					dropActions.add(item.getDropAction());

				for (Action drop : dropActions)
					drop.execute(target, map);

				map.locationOf(target).addItem(corpse);
				corpse.setZombieCap(ZombieCapability.UNDEAD);
			}
			map.removeActor(target);
			result += System.lineSeparator() + target + " is killed.";
		}

		return result;
//		Corpse corpse = new Corpse();
//		return corpse.execute(map, target);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}
}
