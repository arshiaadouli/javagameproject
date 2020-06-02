package game;

import edu.monash.fit2099.engine.*;
import game.*;

import java.util.ArrayList;
import java.util.Random;

public class MamboMarie extends ZombieActor {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */



    private ArrayList<Behaviour> behaviours = new ArrayList<>();


    public MamboMarie(String name) {
        super(name, '.', 50, ZombieCapability.UNDEAD);
        behaviours.add(new WanderBehaviour());


    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {

        turn++;



        Random random = new Random();
        if(random.nextDouble() <= 0.25){
            this.displayChar= 'X' ;

            appearance=true;
        }



        if(turn % 8 == 0){
            behaviours.add(0, new ChantingBehaviour());
        }

        else{
            if(behaviours.size()==2){
                behaviours.remove(0);
            }
        }




        if(turn % 30 == 0){
            this.displayChar='.';
            appearance = false;
        }


        if(this.displayChar=='.'){
            appearance=false;
        }
        if(this.displayChar=='X'){
            appearance=true;
        }


        if(map.contains(this)){
            System.out.println("mambo "+appearance);
            for (Behaviour behaviour : behaviours) {
                Action action = behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }










        return new DoNothingAction();
    }
}
