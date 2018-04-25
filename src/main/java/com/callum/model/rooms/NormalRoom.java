package com.callum.model.rooms;

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
    public NormalRoom(String description) {
        super(description);
    }

    @Override
    public Room getExit(String direction) {
        return (Room)exits.get(direction);
    }


}
