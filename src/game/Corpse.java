package game;


import edu.monash.fit2099.engine.*;

public class Corpse {

    /**
     *
     * @param map the map which the target actor is in there
     * @param target the target actor
     * @return the statement that which actor is killed
     */
    public String execute(GameMap map, Actor... target) {
        String result = "";
        
        for (Actor actor : target) {
            if (!actor.isConscious()) {
                PortableItem corpse = null;

                if (actor.hasCapability(ZombieCapability.ALIVE)) {
                    corpse = new PortableItem("dead " + target, '%');
                    Actions dropActions = new Actions();

                    for (Item item : actor.getInventory())
                        dropActions.add(item.getDropAction());

                    for (Action drop : dropActions)
                        drop.execute(actor, map);

                    map.locationOf(actor).addItem(corpse);
                    corpse.setZombieCap(ZombieCapability.ALIVE);
                } else {
                    corpse = new PortableItem("dead " + target, '%');
                    Actions dropActions = new Actions();

                    for (Item item : actor.getInventory())
                        dropActions.add(item.getDropAction());

                    for (Action drop : dropActions)
                        drop.execute(actor, map);

                    map.locationOf(actor).addItem(corpse);
                    corpse.setZombieCap(ZombieCapability.UNDEAD);
                }
                map.removeActor(actor);
                result += System.lineSeparator() + target + " is killed."+ "\n";
            }
        }

        return result;
    }
}

