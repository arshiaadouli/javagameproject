package game;

import java.util.Random;

import edu.monash.fit2099.engine.*;

public class DropBehaviour implements Behaviour {


    @Override
    public Action getAction(Actor actor, GameMap map) {

        Item item = null;
        if(actor.getNumArm() == 0) {
            if (!(actor.getWeapon() instanceof IntrinsicWeapon)) {
//                return new DropItemAction((Item)actor.getWeapon());
                item = (Item) actor.getWeapon();
            }
        }

        if(actor.getNumArm() == 1) {
            if (!(actor.getWeapon() instanceof IntrinsicWeapon)) {
//                return new DropItemAction((Item)actor.getWeapon());
                Random random = new Random();
                if(random.nextDouble() <= 0.5) {
                    item = (Item) actor.getWeapon();
                }
            }
        }

        if (item != null) {

            return new DropAction(item);
        }
        return null;
    }
}
