package com.callum.model.Parsers;

import com.callum.model.rooms.factory.RoomFactory;
import com.callum.model.rooms.RoomSet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by callummarriage on 27/04/2018.
 */
public class RoomParser {

    public static RoomSet readFile(String file){
        RoomSet roomSet = new RoomSet();

        try {
            Object object = new JSONParser().parse(new FileReader(file));

            JSONArray jsonArray= (JSONArray) object;

            RoomFactory roomFactory = new RoomFactory();

            for(Object o : jsonArray) {
                JSONObject room = (JSONObject) o;
                roomSet.addRoom(roomFactory.createRoom((String) room.get("roomType"),(String) room.get("roomName"), (String) room.get("description"), Boolean.parseBoolean((String) room.get("isLocked")), Boolean.parseBoolean((String) room.get("isBossRoom"))));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return roomSet;
    }
}
