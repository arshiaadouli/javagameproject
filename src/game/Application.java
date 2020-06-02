package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * The main class for the zombie apocalypse game..
 *
 */

public class Application {
//
//	public static ArrayList<Actor> actors;
//	public static Actor player1;
//	public static GameMapDemo getGameMap;
//	public static ArrayList<GameMap> temp;
	public static void main(String[] args) throws IOException {
		ArrayList<GameMap> allGameMaps = new ArrayList<>();

		WorldSub world = new WorldSub(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Fence(), new Tree());
		
		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		"....................................##########..................................",
		"..........................###########........#####..............................",
		"............++...........##......................########.......................",
		"..............++++.......#..............................##......................",
		".............+++...+++...#...............................#......................",
		".........................##..............................##.....................",
		"..........................#...............................#.....................",
		".........................##...............................##....................",
		".........................#...............................##.....................",
		".........................###..............................##....................",
		"...........................####......................######.....................",
		"..............................#########.........####............................",
		"............+++.......................#.........#...............................",
		".............+++++....................#.........#...............................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		GameMapDemo gameMap = new GameMapDemo(groundFactory, map );
		GameMapDemo gameMap1 = new GameMapDemo(groundFactory, map );

		world.addGameMap(gameMap);
		world.addGameMap(gameMap1);

		
		Actor player = new Player("Player", '@', 3000);
//		player1 = player;
		world.addPlayer(player, gameMap.at(42, 13));
		gameMap.at(42, 13).addItem(new SniperRifle());
		world.addPlayer(player, gameMap.at(1, 0));

	    // Place some random humans
		String[] humans = {"Carlton", "Carlton", "Carlton", "Carlton", "Carlton", "Carlton", "Carlton" , "Carlton", "Carlton", "Carlton", "Carlton", "Carlton"};
//		String[] humans = {"arshia"};
		int x, y;
		for (String name : humans) {
			do {
				x = (int) Math.floor(Math.random() * 20.0 + 30.0);
				y = (int) Math.floor(Math.random() * 7.0 + 5.0);
			}
			while (gameMap.at(x, y).containsAnActor());
			gameMap.at(x,  y).addActor(new Human(name));
		}

		// place a simple weapon
			gameMap.at(42, 13).addItem(new Plank());
//		gameMap.at(30, 18).addItem(new Plank());
		
		// FIXME: Add more zombies!
//		gameMap.at(79, 20).addActor(new Zombie("Groan"));
//		gameMap.at(30,  18).addActor(new Zombie("Boo"));
//		gameMap.at(10,  4).addActor(new Zombie("Uuuurgh"));
//		gameMap.at(50, 18).addActor(new Zombie("Mortalis"));
//		gameMap.at(1, 10).addActor(new Zombie("Gaaaah"));
		gameMap.at(30, 10).addActor(new Zombie("Aaargh"));

		gameMap1.at(5, 0).addActor(new Zombie("Aaargh"));
		
		// testing code for Farmer class
		gameMap.at(44, 15).addActor(new Farmer("Joseph", 100));
		gameMap.at(0, 0).addActor(new MamboMarie("mambo"));
		gameMap1.at(44, 15).addActor(new Farmer("Joseph", 100));

		Car car1 = new Car("car1");
		Car car2 = new Car("car2");

		car1.addAction(new TransfterAction(gameMap1));
		car2.addAction(new TransfterAction(gameMap));

		gameMap.at(42, 14).addItem(car1);
//		gameMap.at(0, 0).addItem(new Car("car3"));

		gameMap1.at(1, 1).addItem(car2);



		allGameMaps.add(gameMap);
		allGameMaps.add(gameMap1);

//		temp = world.getAllActors();
//		actors = new ArrayList<>();


//		for(Actor actor : gameMap1.getAllLocations()){
//			actors.add(actor);
//			System.out.println(actor.toString());
//		}


//		getGameMap = gameMap;




		world.run();
	}
}
