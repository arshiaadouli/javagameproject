package game;

import java.util.Random;

import edu.monash.fit2099.engine.*;

/**
 * this class will use the drop action for Zombies
 * @Author Arshia Adouli
 */
public class DropBehaviour implements Behaviour {

    /**
     * if the zombie has one arm, with probability of 50% of the turns, the zombie will drop the weapon which it is holding
     * and if the zombies has no arms, in every turns the zombie will drop the weapon which it is holding
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return new DropAction() or null.
     */
    @Override

    public Action getAction(Actor actor, GameMap map) {

        Item item = null;
        if(actor.getNumArm() == 0) {
            if (!(actor.getWeapon() instanceof IntrinsicWeapon)) {
                item = (Item) actor.getWeapon();
            }
        }

        if(actor.getNumArm() == 1) {
            if (!(actor.getWeapon() instanceof IntrinsicWeapon)) {
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
