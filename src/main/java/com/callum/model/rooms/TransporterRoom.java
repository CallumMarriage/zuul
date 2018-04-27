package com.callum.model.rooms;

import com.callum.model.characters.Character;

import java.security.SecureRandom;
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
    public TransporterRoom(String description, boolean isLocked) {

        super(description, isLocked);
        roomSet = new RoomSet(new SecureRandom());
    }

    @Override
    public Room getExit(String direction) {
        return roomSet.findRandomRoom();
    }

    public void setRoomSet(RoomSet roomSet){
        this.roomSet = roomSet;
    }
}
