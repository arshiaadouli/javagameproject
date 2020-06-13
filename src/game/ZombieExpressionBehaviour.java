package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

import java.util.Random;

/**
 * this class allow zombies to us its expression with
 * probability of 10%
 */
public class ZombieExpressionBehaviour implements Behaviour {
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Random random = new Random();
        
        if(random.nextDouble() <= 0.1){
            return new ZombieExpressionAction();
        }
        
        return null;
    }
}
