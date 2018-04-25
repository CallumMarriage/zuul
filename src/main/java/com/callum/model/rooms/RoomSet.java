package com.callum.model.rooms;

import com.callum.model.rooms.Room;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by callummarriage on 20/04/2018.
 */
public class RoomSet {
    private ArrayList rooms;
    private Random random;

    public RoomSet(Random random){
        this.random = random;
        rooms = new ArrayList();
    }

    public void addRoom(Room newRoom){
        rooms.add(newRoom);
    }

    public Room findRandomRoom(){
        if(rooms.size()==0){
            return null;
        }
        int i = random.nextInt(rooms.size());
        return (Room) rooms.get(i);
    }
}
