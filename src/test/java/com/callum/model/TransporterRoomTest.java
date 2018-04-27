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
        TransporterRoom transporterRoom = new TransporterRoom("a", false);
        NormalRoom room = new NormalRoom("other", false);
        RoomSet roomSet = new RoomSet(new SecureRandom());
        roomSet.addRoom(room);
        transporterRoom.setRoomSet(roomSet);

        assertSame(room, transporterRoom.getExit("any"));


        assertEquals(.3, .15 + .15, 1e-6);


    }

    @Test
    public void testGetExitMultiple(){
        TransporterRoom transporterRoom = new TransporterRoom("a", false);
        NormalRoom room = new NormalRoom("other", false);
        NormalRoom room2 = new NormalRoom("another", false);
        RoomSet roomSet = new RoomSet(new SecureRandom());
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
