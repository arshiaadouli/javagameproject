package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.*;

/**
 * A Zombie.
 * 
 * This Zombie is pretty boring.  It needs to be made more interesting.
 * 
 * @author ram
 *
 */
public class Zombie extends ZombieActor {
	public double punchChance = 0.5;

	public ArrayList<Limb> items = new ArrayList<>();
	public int numArm;
	public int numLeg;
	public int turn = 0;





	private Behaviour[] behaviours = {
			new AttackBehaviour(ZombieCapability.ALIVE),
			new PickUpBehaviour(),
			new HuntBehaviour(Human.class, 10),
			new WanderBehaviour()
	};

	public Zombie(String name) {
		super(name, 'Z', 100, ZombieCapability.UNDEAD);

		items.add(new Arm("left arm"));
		items.add(new Arm("right arm"));
		items.add(new Leg("left leg"));
		items.add(new Leg("right leg"));
	}
	

	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		Random random = new Random();
		double d = random.nextDouble();
		if(d <= punchChance)
			return new IntrinsicWeapon(10, "punches");
		else
			return new IntrinsicWeapon(15, "bites");
	}

	public Limb temp = null;
	@Override
	public void hurt(int points){

		super.hurt(points);
		if(items.size() >= 1) {
			Random random1 = new Random();
			if(random1.nextDouble() <= 0.25){

				Random random2 = new Random();
				int item =  random2.nextInt(items.size());
				temp = items.remove(item);
				System.out.println(temp.toString() + "  has been removed from "+ this.toString());

			}


		}

	}

	/**
	 * If a Zombie can attack, it will.  If not, it will chase any human within 10 spaces.  
	 * If no humans are close enough it will wander randomly.
	 * 
	 * @param actions list of possible Actions
	 * @param lastAction previous Action, if it was a multiturn action
	 * @param map the map where the current Zombie is
	 * @param display the Display where the Zombie's utterances will be displayed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		turn += 1;
		if (temp != null){
			map.locationOf(this).addItem((Item)temp);
			temp = null;
		}
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			if (action != null)
				return action;
		}
		return new DoNothingAction();	
	}
}
