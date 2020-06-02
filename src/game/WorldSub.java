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
    boolean playerWins=false;
    boolean playerLoses=false;


    @Override
    protected boolean stillRunning() {


        int aliveNum = 0;
        int unDeadNum = 0;







        for(Actor actor : actorLocations) {


            if(actor.hasCapability(ZombieCapability.UNDEAD)){
                unDeadNum += 1;

            }
            else if(actor.hasCapability(ZombieCapability.ALIVE)){

                aliveNum += 1;
            }

        }
        if(aliveNum==1){
            playerLoses=true;
        }
        if(unDeadNum==0){
            playerWins=true;
        }

        return (actorLocations.contains(player)&& aliveNum!=1 && unDeadNum != 0);

    }



    @Override

    protected String endGameMessage() {

        if(playerLoses)
        return "player loses";
        if(playerWins)
            return "player Wins";
        if(actorLocations.contains(player))
            return "player loses";
        return "";
    }

}
