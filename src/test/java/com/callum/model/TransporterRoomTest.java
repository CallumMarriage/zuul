package com.callum.model;

import com.callum.model.rooms.NormalRoom;
import com.callum.model.rooms.RoomSet;
import com.callum.model.rooms.TransporterRoom;
import org.junit.Test;

import static org.junit.Assert.*;

import java.security.SecureRandom;

/**
 * Created by callummarriage on 24/04/2018.
 */
public class TransporterRoomTest {

    @Test
    public void testGetExitOne(){
        TransporterRoom transporterRoom = new TransporterRoom("a", "a", false, false);
        NormalRoom room = new NormalRoom("other", "other", false, false);
        RoomSet roomSet = new RoomSet();
        roomSet.addRoom(room);
        transporterRoom.setRoomSet(roomSet);

        assertSame(room, transporterRoom.getExit("any"));
    }

    @Test
    public void testGetExitMultiple(){
        TransporterRoom transporterRoom = new TransporterRoom("a", "a", false, false);
        NormalRoom room = new NormalRoom("other", "other", false, false);
        NormalRoom room2 = new NormalRoom("another", "another", false, false);
        RoomSet roomSet = new RoomSet();
        roomSet.addRoom(room);
        roomSet.addRoom(room2);
        transporterRoom.setRoomSet(roomSet);

        int i = 0;
        int roomOneCount = 0;
        while(i < 180){
            if(transporterRoom.getExit("any").getShortDescription().equals("other")){
                roomOneCount++;
            }
            i++;
        }
        System.out.println(roomOneCount);
        assertTrue(roomOneCount != 0 && roomOneCount < i);
    }
}
