package com.callum.model;

import com.callum.model.rooms.NormalRoom;
import com.callum.model.rooms.RoomSet;
import com.callum.model.rooms.TransporterRoom;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Random;

/**
 * Created by callummarriage on 24/04/2018.
 */
public class TransporterRoomTest {

    @Test
    public void testGetExitOne(){
        TransporterRoom transporterRoom = new TransporterRoom("a");
        NormalRoom room = new NormalRoom("other");
        RoomSet roomSet = new RoomSet(new Random(10));
        roomSet.addRoom(room);
        transporterRoom.setRoomSet(roomSet);

        assertSame(room, transporterRoom.getExit("any"));
    }

    @Test
    public void testGetExitMultiple(){
        TransporterRoom transporterRoom = new TransporterRoom("a");
        NormalRoom room = new NormalRoom("other");
        NormalRoom room2 = new NormalRoom("another");
        RoomSet roomSet = new RoomSet(new Random(10));
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
