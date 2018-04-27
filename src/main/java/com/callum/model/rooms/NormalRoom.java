package com.callum.model.rooms;

import com.callum.model.characters.Character;

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
    public NormalRoom(String description, boolean isLocked) {
        super(description, isLocked);
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
