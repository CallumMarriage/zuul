package com.callum.model.rooms;

import java.util.Random;

/**
 * Created by callummarriage on 20/04/2018.
 */
public class TransporterRoom extends Room {

    private RoomSet roomSet;
    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court
     * yard".
     *
     * @param description
     */
    public TransporterRoom(String description) {

        super(description);
        roomSet = new RoomSet(new Random(42));
    }

    @Override
    public Room getExit(String direction) {
        return roomSet.findRandomRoom();
    }

    public void setRoomSet(RoomSet roomSet){
        this.roomSet = roomSet;
    }
}
