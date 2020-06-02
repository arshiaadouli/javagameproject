package game;

import edu.monash.fit2099.engine.ActorLocations;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.GroundFactory;

import java.io.IOException;
import java.util.List;

public class GameMapDemo extends GameMap {


    public GameMapDemo(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory, lines);
    }

    public ActorLocations getAllLocations(){
        return actorLocations;
    }
}
