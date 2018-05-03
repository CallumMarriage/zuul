package com.callum.model.rooms;

import com.callum.model.Parsers.EnemyParser;
import com.callum.model.Parsers.RoomParser;
import com.callum.model.characters.enemies.BossEnemy;
import com.callum.model.characters.enemies.Enemy;
import com.callum.model.characters.enemies.EnemySet;
import com.callum.model.items.Item;
import com.callum.model.Parsers.ItemParser;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static com.callum.model.constants.GameConstants.ROOMS;

/**
 * Created by callummarriage on 29/04/2018.
 */
public class MapBuilder {

    public void start(List<Area> basicMap){
        List<RoomSet> rooms = buildAreas(RoomParser.readFile(ROOMS));
        List<Item> items = ItemParser.readFile();
        EnemySet enemies = EnemyParser.readFile();
        createRooms(basicMap, rooms, items, enemies);
    }

    private List<Area> connectAreas(List<RoomSet> rooms, Area previousArea){
        List<Area> areas = new ArrayList<>();

        for(int i = 0; i < rooms.size(); i++){

            Area currentArea = groupRoomsAsArea(rooms.get(i));
            try {
                if (connectTwoAreas( previousArea, currentArea)) {
                    areas.add(previousArea);
                } else {
                    System.out.println("Room creation failure");
                    return null;
                }
                if(i + 1 == rooms.size()){
                    areas.add(currentArea);
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        return areas;
    }
    /**
     * Create all the rooms and link their exits together.
     */
    public void createRooms(List<Area> basicMap, List<RoomSet> rooms,List<Item> items, EnemySet enemies ) {
        RoomSet allRooms = new RoomSet();
        Area baseArea, bossArea;
        baseArea = basicMap.get(0);
        bossArea = basicMap.get(1);
        baseArea.getNorthRoom().setExit("east", bossArea.getCentralRoom());
        Area previousArea = baseArea;
        List<Area> areas= connectAreas(rooms, previousArea);
        if(areas == null) {
            return;
        }
        for(int i = 0; i < areas.size(); i++) {
            for(Room room : areas.get(i).getAllRooms().getRooms()){
                allRooms.addRoom(room);
            }
        }
        for(Item item : items){
            Room room =  allRooms.findRandomRoom();
            room.setItem(item);
        }
        for(Room room : bossArea.getAllRooms().getRooms()){
            allRooms.addRoom(room);
        }
        setUpEnemies(allRooms, enemies);
    }

    public void setUpEnemies(RoomSet allRooms, EnemySet enemies){
        for(Enemy enemy : (List<Enemy>) enemies.getEnemies()){
            if(enemy instanceof BossEnemy){
                for(Room room : allRooms.getRooms()){
                    if(room.getIsBossRoom()){
                        room.setEnemy(enemy);
                        break;
                    }
                }
            } else {
                allRooms.findRandomRoom().setEnemy(enemy);
            }
        }
    }

    public Boolean connectTwoAreas(Area previousArea, Area currentArea) throws Exception{
        if( previousArea.getCentralRoom().joinRooms("north", currentArea.getSouthRoom())){
            return true;
        } else{
            System.out.println("Error connecting Areas");
            return false;
        }

    }

    public List<RoomSet> buildAreas(RoomSet rooms){
        RoomSet oldRooms = new RoomSet();
        List<RoomSet> allAreas = new ArrayList<>();

        int base = rooms.getRooms().size() / 4;
        int numberOfRoomsInThisArea = rooms.getRooms().size() / base;
        int increments = numberOfRoomsInThisArea;
        int firstRoom = 0;

        while (numberOfRoomsInThisArea <= rooms.getRooms().size()) {
            RoomSet roomsInCurrentArea = new RoomSet();

            for (int i = firstRoom; i < numberOfRoomsInThisArea; i++) {
                Room newRoom = rooms.findRandomRoom();
                if (!oldRooms.getRooms().contains(newRoom) ) {
                    roomsInCurrentArea.addRoom(newRoom);
                    oldRooms.addRoom(newRoom);
                }
            }
            allAreas.add(roomsInCurrentArea);
            firstRoom += increments;
            numberOfRoomsInThisArea += increments;
        }

        return allAreas;
    }

    public Area groupRoomsAsArea(RoomSet rooms){
        List<Room> newRooms = rooms.getRooms();

        switch (newRooms.size()){
            case 1: return new Area(newRooms.get(0));
            case 2: return new Area(newRooms.get(0), newRooms.get(1));
            case 3: return new Area(newRooms.get(0), newRooms.get(1), newRooms.get(2));
            case 4: return new Area(newRooms.get(0), newRooms.get(1), newRooms.get(2), newRooms.get(3));
            case 5: return new Area(newRooms.get(0), newRooms.get(1), newRooms.get(2), newRooms.get(3), newRooms.get(4));
            default: return null;
        }
    }
}
