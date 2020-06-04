package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.Random;

public class WorldSub extends World {

    private int[] xChoices ;
    private int[] yChoices ;
    public static boolean isDead = true;

    /**
     * Constructor.
     *
     * @param display the Display that will display this World.
     */
    public WorldSub(Display display) {
        super(display);
        boolean isThereMamba=false;
    }
    int turn = 0;


    private boolean temp = false;



    public ArrayList<GameMap> getAllActors(){
        return super.gameMaps;
    }
    boolean playerWins=false;
    boolean playerLoses=false;




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

//            boolean isThereMamba = false;
            MamboMarie mambo = new MamboMarie("mambo");
            Random random = new Random();
            double chance = random.nextDouble();



//            for(Actor actor : actorLocations){
//                if(actor instanceof MamboMarie){
//                    isThereMamba=true;
//                }
//                else{
//                    isThereMamba=false;
//                }
//            }
//


            if(isDead) {
                if (chance <= 0.05) {


                    Random random1 = new Random();
                    xChoices = new int[]{gameMaps.get(0).getXRange().min(), gameMaps.get(0).getXRange().max()};
                    yChoices = new int[]{gameMaps.get(0).getYRange().min(), gameMaps.get(0).getYRange().max()};
                    int x = xChoices[random1.nextInt(2)];
                    int y = yChoices[random1.nextInt(2)];

                    gameMaps.get(0).addActor(mambo, gameMaps.get(0).at(x, y));
                    isDead=false;
                    temp=true;


                }
            }







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

    @Override
    protected boolean stillRunning() {

//        System.out.println(turn);


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
        System.out.println(unDeadNum);
        if(unDeadNum==0 && !MamboMarie.getIsAlive()){
            playerWins=true;
        }

        return (actorLocations.contains(player)&& aliveNum!=1 && (unDeadNum != 0 || MamboMarie.getIsAlive()));

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
