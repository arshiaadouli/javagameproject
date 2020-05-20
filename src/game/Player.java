package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the Player.
 */
public class Player extends Human {
	private Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}
	
//	private void addCraftAction(Actions actions) {
//		for (Item i : inventory) {
//			if (i.isHasIt()) {
//				actions.add(new CraftAction(i));
//			}
//		}
//	}
	
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		System.out.println("items in player's inventory");
		for(Item i : this.inventory){
			System.out.println(i.toString());
			if(i instanceof Leg){
				System.out.println(((Leg) i).hasIt);
			}
		}

//		for(Item i : inventory){
//			if(i.isHasIt()){
//				actions.add(new CraftAction());
//			}



//			if(i instanceof Arm){
//				if( ((Arm) i).isHasIt() ){
//
//					actions.add(new CraftAction());
//				}
//			}
//
//
//			else if(i instanceof Leg){
//				if( ((Leg) i).isHasIt() ){
//
//					actions.add(new CraftAction());
//				}
//			}

		this.addHarvestAction(actions, this, map);
		this.addCraftAction(actions, this);
		this.addEatFoodAction(actions, this);
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		return menu.showMenu(this, actions, display);
	}
}
