package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.*;

public class PickUpBehaviour implements Behaviour {

	public PickUpBehaviour() {

	}

	@Override
	public Action getAction(Actor actor, GameMap map) {

//
//        ArrayList<Item> items = new ArrayList<>();
//
//        for(Item i : map.locationOf(actor).getItems()) {
//            items.add(i);
//        }
//
//        for(Item i : items){
////            System.out.println("an Item");
//            actor.addItemToInventory(i);
//            map.locationOf(actor).removeItem(i);
//        }

//        if(map.locationOf(actor).getItems().size()>0) {
//            Item item = map.locationOf(actor).getItems().get(0);
//            if(!(item instanceof Limbs)) {
//                return new PickUpItemAction(item);
//            }
//        }

		if(actor.getNumArm() > 0) {
			ArrayList<Item> items = new ArrayList<>();
			for (Item i : map.locationOf(actor).getItems()) {
				items.add(i);
			}

			for (Item i : items) {

				if (i instanceof WeaponItem) {
					return new PickUpItemAction(i);
				}
			}
		}


//        }



//        int num=0;
//
//        ArrayList<Item> items = new ArrayList<>();
//
//        for(Item i : map.locationOf(actor).getItems()) {
//            if(!(i instanceof Item2 ))
//            items.add(i);
//        }


//        for(Item i : items){
//            if(!(i instanceof Item2)){
//                actor.addItemToInventory(i);
//                System.out.println(actor.toString() + " picked up " + i.toString() );
//                map.locationOf(actor).removeItem(i);
//                num+=1;
//
//            }
//        }
//        if(num!=0)
//            return new DoNothingAction();


		return null;
	}

}
