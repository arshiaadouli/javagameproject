package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Action class that gives the Player options to shoot their shotgun in a direction.
 * @author Joseph Yu
 *
 */
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
		
		System.out.println(first + second + ": (" + direction.get(0) + ", " + direction.get(1) + ")");
		
		if (direction.get(0) == 0 || direction.get(1) == 0) { // for N, S, E, W directions
			for (int layerNum = 1; layerNum <= 3; layerNum++) {
				int direct = 0;
				// loop through each layer from the actor towards the direction they're shooting at
				if (direction.get(0) == 0) { // N and S
					direct = actorX;
				}
				
				if (direction.get(1) == 0) { // E (-1, 0) and W (1, 0)
					direct = actorY;
				}
				
				for (int i = direct - layerNum; i <= direct + layerNum; i++) {
					if (direction.get(0) == 0) { // N and S
						x = i;
						y = actorY - (direction.get(1) * layerNum);
					}
					
					if (direction.get(1) == 0) { // E and W
						x = actorX - (direction.get(0) * layerNum);
						y = i;
					}
					// set damage of shotgun depending on how far away they are from the actor
					if (layerNum == 1) {
						shotgun.resetDamage();
						shotgun.setDamage(shotgun.damage() * 4);
					}
					else if (layerNum == 2) {
						shotgun.resetDamage();
						shotgun.setDamage(shotgun.damage() * 2);
					}
					
					if (x >= 0 && y >= 0) {
						// testing code
//						System.out.println("x: " + x);
//						System.out.println("y: " + y);
//						System.out.println();
						
						if (map.at(x, y).containsAnActor()) {
							Actor target = map.at(x, y).getActor();
							target.hurt(shotgun.damage());
							new Corpse().execute(map, target);
							retVal += "\n" + actor + " hit " + target + " for " + shotgun.damage();
							shotgun.resetDamage();
						}
					}
				}
			}
		}
		// for NE, NW, SE, SW directions
		else {
			if (direction.get(0) == -1) { // NE, SE
				int layerNum = 4;
				for (int row = 0; row < 4; row++) {
					for (int col = 0; col < layerNum; col++) {
						x = actorX + col;
						y = actorY + row;
						
						if (direction.get(1) == 1) {
							y = actorY - row;
						}
						
						// testing code
//						System.out.println("x: " + x);
//						System.out.println("y: " + y);
//						System.out.println();
						
						if (x >= 0 && y >= 0) {
							if (map.at(x, y).containsAnActor() && !map.at(x, y).getActor().equals(actor)) {
								setShotgunDamage(shotgun, x, y, actorX, actorY);
								Actor target = map.at(x, y).getActor();
								target.hurt(shotgun.damage());
								new Corpse().execute(map, target);
								retVal += "\n" + actor + " hit " + target + " for " + shotgun.damage();
								shotgun.resetDamage();
							}
						}
					}
					layerNum--;
				}
			}
			if (direction.get(0) == 1) { // NW, SW
				int layerNum = 4;
				for (int row = 0; row < 4; row++) {
					for (int col = 0; col > -layerNum; col--) {
						x = actorX + col;
						y = actorY + row;
						
						if (direction.get(1) == 1) {
							y = actorY - row;
						}
						
						// testing code
//						System.out.println("x: " + x);
//						System.out.println("y: " + y);
//						System.out.println();
						
						if (x >= 0 && y >= 0) {
							if (map.at(x, y).containsAnActor() && !map.at(x, y).getActor().equals(actor)) {								
								Actor target = map.at(x, y).getActor();
								target.hurt(shotgun.damage());
								new Corpse().execute(map, target);
								retVal += "\n" + actor + " hit " + target + " for " + shotgun.damage();
								shotgun.resetDamage();
							}
						}
					}
					layerNum--;
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
	
	private void setShotgunDamage(Shotgun shotgun, int x, int y, int aX, int aY) {
		int xDir = -direction.get(0);
		int yDir = -direction.get(1);
		
		if ((x == aX + xDir && y == aY) ||
		(x == aX && y == aY + yDir)) {
			shotgun.setDamage(shotgun.damage() * 4);
		}
		else if ((x == aX + (xDir * 2) && y == aY) ||
		(x == aX && y == aY + (yDir * 2)) ||
		(x == aX + xDir && y == aY + yDir)) {
			shotgun.setDamage(shotgun.damage() * 2);
		}
	}
	
}
