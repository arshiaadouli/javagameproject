package game;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.interfaces.ActorInterface;

import java.util.ArrayList;
import java.util.Random;

public class MamboMarie extends ZombieActor implements ActorInterface {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */


    private static boolean isAlive=true;

    private ArrayList<Behaviour> behaviours = new ArrayList<>();




    private boolean temp=true;
    private int health = 0;
    private boolean isDead = false;



    public MamboMarie(String name) {
        super(name, 'X', 50, ZombieCapability.UNDEAD);
        behaviours.add(new WanderBehaviour());




    }
    public static boolean getIsAlive(){
        return isAlive;
    }

    @Override
    public boolean isConscious(){
        if(hitPoints  > 0){
            return true;
        }
        else{

            isAlive=false;
            return false;

        }

    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {

        isAppear=false;
        turn++;


        if(!isAlive)
        System.out.println("mambo is dead");



        if(this.turn % 10 == 0){
            behaviours.add(0, new ChantingBehaviour());
        }


        else{
            if(behaviours.size()==2){
                behaviours.remove(0);
            }
        }




            if(this.turn%30==0){
                map.removeActor(this);
                WorldSub.isDead=true;




            }


        if(this.displayChar!='X'){
            isAppear =false;
        }
        if(this.displayChar=='X'){
            isAppear=true;
        }




        if(map.contains(this)){

            for (Behaviour behaviour : behaviours) {
                Action action = behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }










        return new DoNothingAction();
    }
}
