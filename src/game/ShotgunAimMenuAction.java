package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ShotgunAimMenuAction extends Action {
	private Shotgun shotgun;
	private ArrayList<Integer> direction; // coordinates representing one of each of the 8 directions
	private String first = ""; // only "North" or "South"
	private String second = ""; // only "East" or "West"
	
	public ShotgunAimMenuAction(Shotgun shotgun, ArrayList<Integer> direction) {
		this.shotgun = shotgun;
		this.direction = direction;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " shotgunned towards " + first + second;
		int actorX = map.locationOf(actor).x();
		int actorY = map.locationOf(actor).y();
		int x = 0;
		int y = 0;
		// for N, S, E, W directions
		if (direction.get(0) == 0 || direction.get(1) == 0) {
			for (int layerNum = 1; layerNum <= 3; layerNum++) {
				// set damage of shotgun depending on how far away they are from the actor
				if (layerNum == 1) {
					shotgun.setDamage(shotgun.damage() * 4);
				}
				else if (layerNum == 2) {
					shotgun.setDamage(shotgun.damage() * 2);
				}
				// loop through each layer from the actor towards the direction they're shooting at
				for (int i = actorX - layerNum; i <= actorX + layerNum; i++) {
					if (direction.get(0) == 0) { // N and S
						x = i;
						y = actorY - direction.get(1) * layerNum;
					}
					if (direction.get(1) == 0) { // E and W
						x = actorX - direction.get(0) * layerNum;
						y = actorY + layerNum;
					}
					
					if (x >= 0 && y >= 0) {
						if (map.at(x, y).containsAnActor()) {
							Actor target = map.at(x, y).getActor();
							target.hurt(shotgun.damage());
							new Corpse().execute(map, target);
							retVal += "\n" + actor + " hit " + target + " for " + shotgun.damage();
						}
					}
				}
			}
		}
		// for NE, NW, SE, SW directions
		else {
			if (direction.get(0) == -1) { // NE, SE
				int num = 4;
				for (int row = 0; row < 4; row++) {
					for (int col = 0; col < num; col++) {
						x = actorX + col;
						y = actorY + row;
						
						if (direction.get(1) == 1) {
							y = actorY - row;
						}
						
						if (x >= 0 && y >= 0) {
							if (map.at(x, y).containsAnActor() && !(map.locationOf(actor).x() == x && map.locationOf(actor).y() == y)) {
								Actor target = map.at(x, y).getActor();
								target.hurt(shotgun.damage());
								new Corpse().execute(map, target);
								retVal += "\n" + actor + " hit " + target + " for " + shotgun.damage();
							}
						}
					}
					num--;
				}
			}
			if (direction.get(0) == 1) { // NW, SW
				int num = 4;
				for (int row = 0; row < 4; row++) {
					for (int col = 0; col > -num; col--) {
						x = actorX + col;
						y = actorY + row;
						
						if (direction.get(1) == 1) {
							y = actorY - row;
						}
						
						if (x >= 0 && y >= 0) {
							if (map.at(x, y).containsAnActor() && !(map.locationOf(actor).x() == x && map.locationOf(actor).y() == y)) {
								Actor target = map.at(x, y).getActor();
								target.hurt(shotgun.damage());
								new Corpse().execute(map, target);
								retVal += "\n" + actor + " hit " + target + " for " + shotgun.damage();
							}
						}
					}
					num--;
				}
			}
		}
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		if (direction.get(0) == 1) {
			second = "West";
		}
		else if (direction.get(0) == -1) {
			second = "East";
		}
		
		if (direction.get(1) == 1) {
			first = "North";
		}
		else if (direction.get(1) == -1) {
			first = "South";
		}
		
		if (!first.equals("") && !second.equals("")) {
			first += "-";
		}
		
		String retVal = actor + " shoots towards " + first + second;
		
		return retVal;
	}
	
}
