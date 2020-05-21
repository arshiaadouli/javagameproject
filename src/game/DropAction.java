package game;

import edu.monash.fit2099.engine.*;

public class DropAction extends Action {

    Item item;

    public DropAction(Item item) {
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();

            if (destination.canActorEnter(actor)) {
                destination.addItem(item);
                actor.removeItemFromInventory(item);
                return actor.toString() + " has dropped "+item.toString();
            }
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
