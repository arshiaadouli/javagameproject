package game;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.interfaces.ActorInterface;

import java.util.ArrayList;

public class MamboMarie extends ZombieActor implements ActorInterface {



    public  static int mamboNum = 0;


    /** this class represent mambo marie which its creation will be provided inside of WorldSub.java
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */


    private ArrayList<Behaviour> behaviours = new ArrayList<>();

    public MamboMarie(String name) {

        super(name, 'X', 50, ZombieCapability.UNDEAD);

        behaviours.add(new WanderBehaviour()); // if she is in the map, she wanders unless she chants

        mamboNum+=1;




    }

    /**
     *
     * @return she never comes back when she dies
     */
    @Override
    public boolean isConscious(){
        if(hitPoints  > 0){
            return true;
        }
        else{

//            mamboNum-=1;
            return false;

        }

    }

    /**
     * play turn of mambo marie which shows whether mambo can wander, chant or vanishes
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return action from the behaviour
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {


        turn++;


        if(this.turn % 10 == 0){ // in every 10 turn it chants and creates 5 zombies(chanting behaviour)
            behaviours.add(0, new ChantingBehaviour());
        }



        else{
            if(behaviours.size()==2){  // otherwise remove the chanting behaviour
                behaviours.remove(0);
            }
        }




            if(this.turn==30){   // in 30th turn it vanishes but she will be brought away  by worldSub
                map.removeActor(this);
//                WorldSub.mamboNum-=1;
            }






        if(map.contains(this)){

            for (Behaviour behaviour : behaviours) { // execute the first behaviour from the list
                Action action = behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }










        return new DoNothingAction();
    }
}
