package edu.monash.fit2099.interfaces;


public interface Crafter {
    /**
     * make a actor to be a crafter
     * @return true
     */
    public default boolean crafter(){
        return true;
    }
}
