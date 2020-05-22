package game;

import edu.monash.fit2099.engine.*;

/**
 * it is an action class which represents the action which a zombie does when it has one or two arms
 * @Author Arshia Adouli
 */
public class DropAction extends Action {

    Item item;

    /**
     * Constructor:
     * @param item:
     *            represent the item which it is used in execute return method.
     *            to tell what to print out
     *            in the console
     *
     */
    public DropAction(Item item) {
        this.item = item;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return in this method the zombie(player) will drop the weapon which was holding before in
     * the adjacent location. this design decision has been made for not allowing zombies to pick up the item
     * after dropping it.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();

            if (destination.canActorEnter(actor)) {
                destination.addItem(item);
                actor.removeItemFromInventory(item);
                return actor.toString() + " has dropped " + item.toString();
            }
        }
        
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
