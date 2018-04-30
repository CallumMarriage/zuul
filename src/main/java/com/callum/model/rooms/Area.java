package com.callum.model.rooms;

import java.security.SecureRandom;

/**
 * Created by callummarriage on 29/04/2018.
 */
public class Area {

    private Room eastRoom;
    private Room westRoom;
    private Room northRoom;
    private Room southRoom;
    private Room centralRoom;
    private int numberOfRooms;

    public Area(Room... room){

        try {
            this.centralRoom = room[0];
            numberOfRooms = 1;
            if(room.length >= 2){
                this.northRoom = room[1];
                centralRoom.joinRandomRooms( northRoom);
                numberOfRooms = 2;
            }
            if (room.length >= 3) {
                this.southRoom = room[2];
                centralRoom.joinRandomRooms( southRoom);
                numberOfRooms = 3;
            }
            if (room.length >= 4) {
                this.eastRoom = room[3];
                centralRoom.joinRandomRooms(eastRoom);
                numberOfRooms = 4;
            }
            if (room.length >= 5) {
                this.westRoom = room[4];
                centralRoom.joinRandomRooms(westRoom);
                numberOfRooms = 5;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Room getEastRoom() {
        return eastRoom;
    }

    public void setEastRoom(Room eastRoom) {
        this.eastRoom = eastRoom;
    }

    public Room getWestRoom() {
        return westRoom;
    }

    public void setWestRoom(Room westRoom) {
        this.westRoom = westRoom;
    }

    public Room getNorthRoom() {
        return northRoom;
    }

    public void setNorthRoom(Room northRoom) {
        this.northRoom = northRoom;
    }

    public Room getSouthRoom() {
        return southRoom;
    }

    public void setSouthRoom(Room southRoom) {
        this.southRoom = southRoom;
    }

    public Room getCentralRoom() {
        return centralRoom;
    }

    public void setCentralRoom(Room centralRoom) {
        this.centralRoom = centralRoom;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public RoomSet getAllRooms(){
        RoomSet roomSet = new RoomSet();
        roomSet.addRoom(getCentralRoom());

        if(numberOfRooms > 1){
            roomSet.addRoom(getNorthRoom());
        }
        if(numberOfRooms > 2){
            roomSet.addRoom(getSouthRoom());
        }
        if(numberOfRooms > 3){
            roomSet.addRoom(getEastRoom());
        }
        if(numberOfRooms > 4){
            roomSet.addRoom(getWestRoom());
        }
        return roomSet;
    }
}
