package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Item;

public class Car extends Item {
    /***
     * Car class represents the vehicle in the game map
     * Constructor.
     *  @param name the name of this Item
*/

    public Car(String name) {
        super(name, 'M', false);

    }

    /**
     * this function add an action to the Car's object's allowable action which it is used
     * in Application file
     * @param action the action which will be added to a car object
     */
    public void addAction(Action action) {
        this.allowableActions.add(action);
    }
}
