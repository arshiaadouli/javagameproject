package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class WorldSub extends World {

    private int[] xChoices ;
    private int[] yChoices ;
    public boolean isMamboVanished = true;
    private boolean isDead = false;
    private boolean isThereMambo= false;


    /**
     * Constructor.
     * this class is a subclass of World.java
     * @param display the Display that will display this World.
     */
    public WorldSub(Display display) {
        super(display);
    }

    MamboMarie mambo = new MamboMarie("mambo"); //mambo marie object


//    private boolean temp = false;



//    public ArrayList<GameMap> getAllActors(){
//        return super.gameMaps;
//    }

    boolean playerWins=false;   //boolean for determining whether player wins
    boolean playerLoses=false;  //boolean for determining whether player loses



    /**
     * this method is the same as World's run method
     * however, in this method there is a 5 %
     * in each turn that the mambo marie appears
     */
    @Override
    public void run() {

        if (player == null)
            throw new IllegalStateException();

        // initialize the last action map to nothing actions;
        for (Actor actor : actorLocations) {
            lastActionMap.put(actor, new DoNothingAction());
        }

        // This loop is basically the whole game

        while (stillRunning()) {


            mambaCreation(); // creating the mambo here


            GameMap playersMap = actorLocations.locationOf(player).map();
            playersMap.draw(display);

            // Process all the actors.
            for (Actor actor : actorLocations) {
                if (stillRunning())
                    processActorTurn(actor);
            }

            // Tick over all the maps. For the map stuff.
            for (GameMap gameMap : gameMaps) {
                gameMap.tick();
            }

        }
        display.println(endGameMessage());
    }


    /**
     * this method creates the mamba in the edge of the map (in the 5% of the turn initially)
     */
    public void mambaCreation(){

        Random random = new Random();
        double chance = random.nextDouble();


        if(isMamboVanished && !isDead) { // if mambo marie is not in the game
            if (chance <= 0.05) {  // create it in 5% in a turn



                Random random1 = new Random();
                xChoices = new int[]{gameMaps.get(0).getXRange().min(), gameMaps.get(0).getXRange().max()};
                yChoices = new int[]{gameMaps.get(0).getYRange().min(), gameMaps.get(0).getYRange().max()};
                int x = xChoices[random1.nextInt(2)];
                int y = yChoices[random1.nextInt(2)];

                try{

//                    MamboMarie.mamboNum+=1;
//                    System.out.println("number of mambo: " + mamboNum);
                    gameMaps.get(0).addActor(mambo, gameMaps.get(0).at(x, y));   // create mambo in edge of the map
                    isMamboVanished = false;  // the mambo marie is alive now
                }
                catch(Exception e){}


            }
        }
        else{ // else: the mambo is appeared on the map
            if(!mambo.isConscious()&&!isDead ){

//
                MamboMarie.mamboNum-=1;
                isDead=true;

//
            }


            isThereMambo = false;
            for(Actor actor : actorLocations){
                if (actor instanceof MamboMarie) {

                    isThereMambo = true;
                    break;
                }
            }
            System.out.println("istheremambo: "+ isThereMambo);

            if(!isThereMambo){
//                System.out.println("is mambo in the map:" + gameMaps.get(0).contains(mambo));
                isMamboVanished=true;

            }
        }

    }



    /**
     * in this method further than existence of player existence of zombies, human and mambo will
     * be explored to see whether the game should be ended.
     * @return if all of the actors from different types were in the game continue else return end message
     */
    @Override
    protected boolean stillRunning() {

        int aliveNum = 0;
        int unDeadNum = 0;

        // loop through all of the actors to find out how many undead and how
        // many alive actors are currently in the map
        // and increment aliveNum and undeadNum

        for(Actor actor : actorLocations) {



            if(gameMaps.get(0).contains(actor)) {  // check the actors in the compound
                if (actor.hasCapability(ZombieCapability.UNDEAD)) {  // get the number of undead armies
                    unDeadNum += 1;

                } else if (actor.hasCapability(ZombieCapability.ALIVE)) {  // get the number of alive armies

                    if(actor!=player) {
                        aliveNum += 1;
                    }
                }
            }

        }
        //if alivenum is one it means we have only the PLAYER in the map which is a loss
        if(aliveNum==0){
            playerLoses=true;
        }
//        System.out.println(unDeadNum);
        if(unDeadNum==0 && MamboMarie.mamboNum==0){ // if the number of the undead army is zero and mambo is dead it is a win
            playerWins=true;
        }


//        System.out.println("number of mambo : " + MamboMarie.mamboNum);
        return (actorLocations.contains(player)&& aliveNum!=0 && (unDeadNum != 0 || MamboMarie.mamboNum!=0));

    }


    /**
     *
     * @return this function returns the final execution (GAME OVER) statement.
     */
    @Override

    protected String endGameMessage() {

        if(playerLoses)
        return "player loses";
        if(playerWins)
            return "player Wins";
        if(!actorLocations.contains(player))
            return "player loses";

        return "";
    }

}
