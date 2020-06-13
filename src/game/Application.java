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

public class Application  {
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
		GameMapDemo compoundMap = new GameMapDemo(groundFactory, map );
		GameMapDemo townMap = new GameMapDemo(groundFactory, map );

		world.addGameMap(compoundMap);
		world.addGameMap(townMap);
		
		Actor player = new Player("Player", '@', 100);

		world.addPlayer(player, compoundMap.at(2, 1));

		// Place some random humans
		String[] humansInCompoundMap = {"Carlton", "Andy", "Matthew", "John", "Joseph", "Arshia"};
		String[] humansInTownMap = {"Daniel", "Homer", "Dick", "Batman", "Kiddie", "Paul"};
		int x, y;
		// add humans to compoundMap
		for (String name : humansInCompoundMap) {
			do {
				x = (int) Math.floor(Math.random() * 20.0 + 30.0);
				y = (int) Math.floor(Math.random() * 7.0 + 5.0);
			}
			while (compoundMap.at(x, y).containsAnActor());
			compoundMap.at(x, y).addActor(new Human(name));
		}
		// add humans to townMap
		for (String name : humansInTownMap) {
			do {
				x = (int) Math.floor(Math.random() * 20.0 + 30.0);
				y = (int) Math.floor(Math.random() * 7.0 + 5.0);
			}
			while (townMap.at(x, y).containsAnActor());
			townMap.at(x, y).addActor(new Human(name));
		}
		
		// FIXME: Add more zombies!
		compoundMap.at(79, 20).addActor(new Zombie("Groan"));
		compoundMap.at(30, 18).addActor(new Zombie("Boo"));
		compoundMap.at(10, 4).addActor(new Zombie("Uuuurgh"));
		compoundMap.at(50, 18).addActor(new Zombie("Mortalis"));
		compoundMap.at(1, 10).addActor(new Zombie("Gaaaah"));
		compoundMap.at(20, 10).addActor(new Zombie("Aaargh"));
		compoundMap.at(32, 16).addActor(new Zombie("Eeeeeek"));
		
		townMap.at(79, 20).addActor(new Zombie("Yikes"));
		townMap.at(30, 18).addActor(new Zombie("Boomer"));
		townMap.at(10, 4).addActor(new Zombie("Zoomer"));
		townMap.at(50, 18).addActor(new Zombie("Dinkles"));
		townMap.at(1, 10).addActor(new Zombie("Bee"));
		townMap.at(20, 10).addActor(new Zombie("Buerl"));
		townMap.at(32, 16).addActor(new Zombie("Damn"));

		// car 1 is created which locates in compound map
		Car car1 = new Car("car1");
		// car 2 is created which locates in town map
		Car car2 = new Car("car2");

		// particularly for car 1 the transfer action added to move player from compound map to town map
		car1.addAction(new TransfterAction(townMap, 0, 0));

		// particularly for car 2 the transfer action added to move player from town map to compound map
		car2.addAction(new TransfterAction(compoundMap, 0, 0));

		compoundMap.at(2, 1).addItem(car1);
		townMap.at(1, 1).addItem(car2);
		allGameMaps.add(compoundMap);
		allGameMaps.add(townMap);
		world.run();
	}
}
