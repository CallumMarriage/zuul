package com.callum.zuul.model.rooms;

/**
 * Created by callummarriage on 20/04/2018.
 */
public class NormalRoom extends Room {

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court
     * yard".
     *
     * @param description
     */
    public NormalRoom(String name,String description, boolean isLocked, boolean isBossRoom) {
        super(name, description, isLocked, isBossRoom);
    }

    @Override
    public Room getExit(String direction) {
        return (Room)exits.get(direction);
    }


    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
