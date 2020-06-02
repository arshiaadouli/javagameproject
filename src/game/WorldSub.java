package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

public class WorldSub extends World {

    /**
     * Constructor.
     *
     * @param display the Display that will display this World.
     */
    public WorldSub(Display display) {
        super(display);
    }


    public ArrayList<GameMap> getAllActors(){
        return super.gameMaps;
    }


    @Override
    protected boolean stillRunning() {


        int aliveNum = 0;
        int unDeadNum = 0;
        ArrayList<Actor> compoundActors = new ArrayList<>();



        for(Actor actor : actorLocations) {

            compoundActors.add(actor);

        }



        for(Actor actor : actorLocations) {
        for()

            if(actor.hasCapability(ZombieCapability.UNDEAD)){
                unDeadNum += 1;

            }
            else if(actor.hasCapability(ZombieCapability.ALIVE)){

                aliveNum += 1;
            }

        }

        return (actorLocations.contains(player)&& aliveNum!=1 && unDeadNum != 0) || (PortableItem.getHumanCorpse());

    }

}
