package game;


import edu.monash.fit2099.engine.*;

public class TempActor extends ZombieActor {
    /**
     * this method creates 2 legs and 2 arms for an actor
     */
    public TempActor() {
        super("tempactor", 'Q', 20, ZombieCapability.UNDEAD);
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
