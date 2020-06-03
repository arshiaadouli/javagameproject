package game;

import edu.monash.fit2099.engine.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class GameMapDemo extends GameMap {


    public GameMapDemo(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory, lines);
    }

//
//    @Override
//    public boolean isAnActorAt(Location location) {
//
//        if(actorLocations.isAnActorAt(location)){
//
//           Actor actor = location.getActor();
//           if(!((ZombieActor)actor).isAppear){
//
//               return false;
//           }
//
//        }
//        return actorLocations.isAnActorAt(location);
//    }
//
//
//    public void moveActor(Actor actor, Location newLocation) {
//
//        Objects.requireNonNull(actor);
//        Actor actor1 = null;
//        if(newLocation.containsAnActor()){
//            actor1 = newLocation.getActor();
//            if((!((ZombieActor)actor).isAppear) || (!((ZombieActor)actor1).isAppear)){
////                this.removeActor(actor);
////                this.addActor(actor, newLocation);
//                actorLocations.move(actor, newLocation);
//            }
//        }
//
//
//
//        actorLocations.move(actor, newLocation);
//    }



}
