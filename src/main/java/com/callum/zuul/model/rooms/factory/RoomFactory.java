package com.callum.zuul.model.rooms.factory;

import com.callum.zuul.model.rooms.NormalRoom;
import com.callum.zuul.model.rooms.Room;
import com.callum.zuul.model.rooms.TransporterRoom;

/**
 * Created by callummarriage on 27/04/2018.
 */
public class RoomFactory {
    public Room createRoom(String type, String name, String description, boolean isLocked, boolean isBossRoom){
        switch (type){
            case "TransporterRoom": return new TransporterRoom(name, description, isLocked, isBossRoom);
            case "NormalRoom": return new NormalRoom(name, description, isLocked, isBossRoom);
            default: return null;
        }
    }
}
