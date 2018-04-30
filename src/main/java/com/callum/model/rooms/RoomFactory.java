package com.callum.model.rooms;

import com.callum.model.items.Health;
import com.callum.model.items.Item;
import com.callum.model.items.Key;

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
