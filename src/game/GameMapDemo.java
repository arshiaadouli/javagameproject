package game;

import edu.monash.fit2099.engine.*;

import java.io.IOException;
import java.util.List;

public class GameMapDemo extends GameMap {


    public GameMapDemo(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory, lines);
    }


    @Override
    public boolean isAnActorAt(Location location) {
//        if(actorLocations.isAnActorAt(location)){
//            Actor actor = getActorAt(location);
//            if(!((ZombieActor) actor).isAppear && actor instanceof MamboMarie){
//                return false;
//
//            }
//        }
        return actorLocations.isAnActorAt(location);
    }




}
