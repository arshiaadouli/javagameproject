package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.engine.Action;

/**
 * Allows an Actor to wander around at random.
 *
 * @author ram
 *
 */
public class WanderBehaviour implements Behaviour {

	private Random random = new Random();
	boolean b = false;


	/**
	 * Returns a MoveAction to wander to a random location, if possible.
	 * If no movement is possible, returns null.
	 *
	 * @param actor the Actor enacting the behaviour
	 * @param map the map that actor is currently on
	 * @return an Action, or null if no MoveAction is possible
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		ArrayList<Action> actions = new ArrayList<Action>();
		ArrayList<Character> chars = new ArrayList<>();

		if (actor.getNumLeg() == 2 || (actor.getNumLeg() == 1 && actor.getNumTurn() % 2 == 0)) {
			for (Exit exit : map.locationOf(actor).getExits()) {
				Location destination = exit.getDestination();
				if (destination.canActorEnter(actor)) {
					actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));

					if(exit.getDestination().getItems().size()>0)
					chars.add(exit.getDestination().getItems().get(exit.getDestination().getItems().size()-1).getDisplayChar());
					else
						chars.add('*');
					b = true;
				}
			}

			if (!actions.isEmpty()) {
				int select = random.nextInt(actions.size());

					if (!((ZombieActor) actor).isAppear) {
						if(b)
							((ZombieActor)actor).setDisplayChar(chars.get(select));
						else
							((ZombieActor)actor).setDisplayChar('*');
					}

					b=false;


				return actions.get(select);
			} else {
				return null;
			}

		}
		else
			return new DoNothingAction();
	}
}
