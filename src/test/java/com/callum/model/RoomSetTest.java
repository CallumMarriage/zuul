package com.callum.model;



import com.callum.model.characters.enemies.KnightEnemy;
import com.callum.model.characters.weapons.Weapon;
import com.callum.model.rooms.NormalRoom;
import com.callum.model.rooms.Room;
import com.callum.model.rooms.RoomSet;
import org.junit.Before;
import org.junit.Test;

import java.security.SecureRandom;

import static org.junit.Assert.*;

/**
 * Created by callummarriage on 24/04/2018.
 */
public class RoomSetTest {

    private RoomSet roomSet;

    private KnightEnemy enemy;
    @Before
    public void beforeTest(){
        roomSet = new RoomSet(new SecureRandom());

         enemy = new KnightEnemy(new Weapon("Steve", 10), "Steve", 200);
    }

    @Test
    public void testEmpty(){
        assertNull(roomSet.findRandomRoom());
    }

    @Test
    public void testOnlyOne(){
        final NormalRoom normalRoom = new NormalRoom("a", false);
        roomSet.addRoom(normalRoom);
        assertSame(normalRoom, roomSet.findRandomRoom());
    }

    @Test
    public void testFindRandomRoom(){
        final NormalRoom normalRoom0 = new NormalRoom("a", false);
        final NormalRoom normalRoom1 = new NormalRoom("b", false);
        final NormalRoom normalRoom2 = new NormalRoom("c", false);
        final NormalRoom normalRoom3 = new NormalRoom("d", false);

        roomSet.addRoom(normalRoom0);
        roomSet.addRoom(normalRoom1);
        roomSet.addRoom(normalRoom2);
        roomSet.addRoom(normalRoom3);

        int zeroRoomTally = 0;
        int oneRoomTally = 0;
        int twoRoomTally = 0;
        int threeRoomTally = 0;

        int i = 0;
        while(i < 400){
            Room currentRoom = roomSet.findRandomRoom();
            if(currentRoom.getShortDescription().equals("a")){
                zeroRoomTally++;
            } else if(currentRoom.getShortDescription().equals("b")){
                oneRoomTally++;

            } else if(currentRoom.getShortDescription().equals("c")){
                twoRoomTally++;
            } else{
                threeRoomTally++;
            }
            i++;
        }
        assertTrue(Math.abs(zeroRoomTally - oneRoomTally) <= 50);
        assertTrue(Math.abs(threeRoomTally - zeroRoomTally)<= 50);
        assertTrue(Math.abs(twoRoomTally - threeRoomTally) <= 50);
    }
}
