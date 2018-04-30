package com.callum.model.Parsers;

import com.callum.model.rooms.RoomFactory;
import com.callum.model.rooms.RoomSet;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.SecureRandom;

import static com.callum.model.constants.GameConstants.ROOMS;

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
