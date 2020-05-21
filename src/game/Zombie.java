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
	private double punchChance = 0.5;

	private ArrayList<Limb> items = new ArrayList<>();
	private int numArm = getNumArm();
	private int numLeg = getNumLeg();
	private int turn = 0;





	private Behaviour[] behaviours = {
			new ZombieExpressionBehaviour(),
			new DropBehaviour(),
			new AttackBehaviour(ZombieCapability.ALIVE),
			new PickUpBehaviour(),
			new HuntBehaviour(Human.class, 10),
			new WanderBehaviour()
	};

	public Zombie(String name) {
		super(name, 'Z', 100, ZombieCapability.UNDEAD);

		items.add(new Leg("left leg", false));
		items.add(new Leg("right leg", false));
//
		items.add(new Arm("left arm", false));
		items.add(new Arm("right arm", false));
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
	@Override

	public int getNumArm() {
		int temp = 0;
		for(Limb i : items){
			if(i instanceof Arm){
				temp +=1;

			}
		}
		return temp;
	}

	@Override
	public int getNumLeg() {
		int temp = 0;
		for(Limb i : items){
			if(i instanceof Leg){
				temp +=1;

			}
		}
		return temp;
	}

	@Override
	public int getNumTurn(){
		return turn;
	}



	public Limb tempLimb = null;

	@Override
	public void hurt(int points){
		super.hurt(points);
		if(items.size() >= 1) {
			Random random1 = new Random();
			if(random1.nextDouble() <= 0.25){
				Random random2 = new Random();
				int item =  random2.nextInt(items.size());
				tempLimb = items.remove(item);
				System.out.println("zombie limbs detached: ");
				System.out.println(tempLimb.toString() + "  has been removed from "+ this.toString());
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


		if (tempLimb != null){
			map.locationOf(this).addItem((Item)tempLimb);
			tempLimb = null;
		}

		if(numArm==1){
			punchChance=0.25;
		}
		if(numArm==0){
			punchChance=0;
		}




		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			if (action != null)
				return action;
		}

		return new DoNothingAction();
	}
}
