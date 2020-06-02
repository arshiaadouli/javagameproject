package game;


import edu.monash.fit2099.engine.*;

public class Corpse {

    public Corpse(){


    }

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

