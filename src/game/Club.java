package game;

import edu.monash.fit2099.engine.WeaponItem;

/**
 * @Author Arshia Adouli
 * this class is used when an actor tries to craft the arm and the arm will
 * be changed to Club object.
 */
public class Club extends WeaponItem {

	public Club() {
		super("Club", 'G', 25, "whacks");
	}
}
