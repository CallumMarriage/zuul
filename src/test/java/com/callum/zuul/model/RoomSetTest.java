package com.callum.zuul.model;



import com.callum.zuul.model.characters.enemies.KnightEnemy;
import com.callum.zuul.model.items.characterItems.weapons.Sword;
import com.callum.zuul.model.rooms.NormalRoom;
import com.callum.zuul.model.rooms.Room;
import com.callum.zuul.model.rooms.RoomSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by callummarriage on 24/04/2018.
 */
public class RoomSetTest {

    private RoomSet roomSet;

    private KnightEnemy enemy;
    @Before
    public void beforeTest(){
        roomSet = new RoomSet();

         enemy = new KnightEnemy(new Sword("Steve","The sword", 10), "Steve", 200);
    }

    @Test
    public void testEmpty(){
        assertNull(roomSet.findRandomRoom());
    }

    @Test
    public void testOnlyOne(){
        final NormalRoom normalRoom = new NormalRoom("a", "a", false, false);
        roomSet.addRoom(normalRoom);
        assertSame(normalRoom, roomSet.findRandomRoom());
    }

    @Test
    public void testFindRandomRoom(){
        final NormalRoom normalRoom0 = new NormalRoom("a","a", false, false);
        final NormalRoom normalRoom1 = new NormalRoom("b","b", false, false);
        final NormalRoom normalRoom2 = new NormalRoom("c", "c", false, false);
        final NormalRoom normalRoom3 = new NormalRoom("d", "d", false, false);

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
