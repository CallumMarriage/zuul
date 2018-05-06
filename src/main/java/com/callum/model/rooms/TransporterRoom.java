package com.callum.model.rooms;

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
    public TransporterRoom(String name, String description, boolean isLocked, boolean isBossRoom) {
        super(name,description, isLocked, isBossRoom);
        roomSet = new RoomSet();
    }

    @Override
    public Room getExit(String direction) {
        return roomSet.findRandomRoom();
    }

    public void setRoomSet(RoomSet roomSet){
        this.roomSet = roomSet;
    }
}
