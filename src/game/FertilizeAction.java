package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Action for humans to fertilize crop objects they are currently standing on.
 * @author Joseph Yu
 *
 */

public class FertilizeAction extends Action {
	/**
	 * Container for the crop object that is to be fertilized.
	 */
	private Crop crop;
	
	public FertilizeAction(Crop crop) {
		this.crop = crop;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String retVal = actor + " fertilized an Unripe Crop";
		
		crop.fertilizeCrop();
		
		return retVal;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " fertilizes an Unripe Crop";
	}
}
