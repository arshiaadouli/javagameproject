package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.engine.Action;

import javax.swing.*;

/**
 * Allows an Actor to wander around at random.
 *
 * @author ram
 *
 */
public class WanderBehaviour implements Behaviour {

	private Random random = new Random();


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

		if (actor.getNumLeg() == 2 || (actor.getNumLeg() == 1 && actor.getNumTurn() % 2 == 0)) {
			for (Exit exit : map.locationOf(actor).getExits()) {
				Location destination = exit.getDestination();
				if (destination.canActorEnter(actor)) {
					actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
				}
			}

			if (!actions.isEmpty()) {
				return actions.get(random.nextInt(actions.size()));
			} else {
				return null;
			}

		}
		else
			return new DoNothingAction();


	}
}
