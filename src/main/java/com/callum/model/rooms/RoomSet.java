package com.callum.model.rooms;

import com.callum.model.rooms.Room;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by callummarriage on 20/04/2018.
 */
public class RoomSet {
    private ArrayList rooms;

    public RoomSet(){
        rooms = new ArrayList();
    }

    public void addRoom(Room newRoom){
        rooms.add(newRoom);
    }

    public Room findRandomRoom(){
        SecureRandom random = new SecureRandom();

        if(rooms.size()==0){
            return null;
        }
        int i = random.nextInt(rooms.size());

        return (Room) rooms.get(i);
    }

    public List<Room> getRooms(){
        return rooms;
    }
}
