package com.callum.zuul.model.parsers;

import com.callum.zuul.model.rooms.Room;
import com.callum.zuul.model.rooms.factory.RoomFactory;
import com.callum.zuul.model.rooms.RoomSet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by callummarriage on 27/04/2018.
 */
public class RoomParser {

    public static List<RoomSet> readFile(String file){
        List<RoomSet> normalAndBossRooms = new ArrayList<>();
        RoomSet roomSet = new RoomSet();
        RoomSet bossRooms = new RoomSet();

        try {
            Object object = new JSONParser().parse(new FileReader(file));

            JSONArray rooms = (JSONArray) object;

            RoomFactory roomFactory = new RoomFactory();

            for(Object Oroom : rooms) {
                JSONObject room = (JSONObject) Oroom;
                Room newRoom = roomFactory.createRoom((String) room.get("roomType"),(String) room.get("roomName"), (String) room.get("description"), Boolean.parseBoolean((String) room.get("isLocked")), Boolean.parseBoolean((String) room.get("isBossRoom")));
                JSONArray exits = (JSONArray) room.get("Exits");
                for(Object Oexit : exits){
                    JSONObject exit = (JSONObject) Oexit;
                    Boolean found = false;
                    for(Room otherRoom : roomSet.getRooms()){
                        if(otherRoom.getName().equals(exit.get("room"))) {
                            found = true;
                            newRoom.joinRooms((String) exit.get("direction"), otherRoom);
                        }
                    }
                    if(!found){
                        for(Room bossRoom : bossRooms.getRooms()){
                            if(bossRoom.getName().equals(exit.get("room"))) {
                                found = true;
                                newRoom.joinRooms((String) exit.get("direction"), bossRoom);
                            }
                        }
                    }
                    if(!found){
                        System.out.println("Room not connected:" + newRoom.getName());
                    }
                }
                if(!newRoom.getIsBossRoom()) {
                    if(room.get("isStartingRoom") != null){
                        newRoom.setIsStartingRoom(true);
                    }
                    roomSet.addRoom(newRoom);
                } else {
                    bossRooms.addRoom(newRoom);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Element one contains the normal rooms
        normalAndBossRooms.add(roomSet);
        //Element two contains the boss rooms
        normalAndBossRooms.add(bossRooms);
        return normalAndBossRooms;
    }
}
