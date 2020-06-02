package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Item;

public class Car extends Item {
    /***
     * Constructor.
     *  @param name the name of this Item
*/

    public Car(String name) {
        super(name, 'M', false);
//        this.allowableActions.add(new TransfterAction());
    }

    public void addAction(Action action) {
        this.allowableActions.add(action);
    }
}
