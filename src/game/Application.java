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
//		GameMapDemo gameMapTemp = new GameMapDemo(groundFactory, map);

		world.addGameMap(gameMap);
		world.addGameMap(gameMap1);

		
		Actor player = new Player("Player", '@', 4000);
//		player1 = player;

//		player.addItemToInventory(new Plank());
		world.addPlayer(player, gameMap1.at(2, 1));
//		player.addItemToInventory(new Plank());
//		player.addItemToInventory(new SniperRifleAmmo());
//		player.addItemToInventory(new SniperRifle());
		player.addItemToInventory(new Shotgun());
		player.addItemToInventory(new ShotgunAmmo());

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
			gameMap.at(x, y).addActor(new Human(name));
		}

		// place a simple weapon
//			gameMap.at(1, 0).addItem(new Plank());
//		gameMap.at(30, 18).addItem(new Plank());
		
		// FIXME: Add more zombies!
//		gameMap.at(79, 20).addActor(new Zombie("Groan"));
//		gameMap.at(30,  18).addActor(new Zombie("Boo"));
//		gameMap.at(10,  4).addActor(new Zombie("Uuuurgh"));
//		gameMap.at(50, 18).addActor(new Zombie("Mortalis"));
//		gameMap.at(1, 10).addActor(new Zombie("Gaaaah"));
//		gameMap.at(20, 10).addActor(new Zombie("Aaargh"));
//		gameMap.at(21, 10).addActor(new Zombie("Aaargh"));


//		gameMap1.at(5, 0).addActor(new Zombie("Aaargh"));
		
		// testing code for Farmer class
		gameMap.at(11, 0).addActor(new Farmer("Joseph", 230));
		gameMap.at(11, 1).addActor(new Zombie("zombie temp"));

//		gameMap.at(0, 0).addActor(new MamboMarie("mambo"));
//		gameMap1.at(44, 15).addActor(new Farmer("Joseph", 100));

		// car 1 is created which locates in compound map
		Car car1 = new Car("car1");
		// car 2 is created which locates in town map
		Car car2 = new Car("car2");

		// particularly for car 1 the transfer action added to move player from compound map to town map
		car1.addAction(new TransfterAction(gameMap1, 0, 0));

		// particularly for car 2 the transfer action added to move player from town map to compound map
		car2.addAction(new TransfterAction(gameMap, 0, 0));

		gameMap.at(2, 1).addItem(car1);
		gameMap1.at(1, 1).addItem(car2);
		gameMap.addActor(new Zombie("arshia1"), gameMap1.at(3, 1));
		allGameMaps.add(gameMap);
		allGameMaps.add(gameMap1);

		world.run();
	}
}
