package com.callum.zuul.model;

import com.callum.zuul.model.parsers.EnemyParser;
import com.callum.zuul.model.parsers.RoomParser;
import com.callum.zuul.model.characters.enemies.BossEnemy;
import com.callum.zuul.model.characters.enemies.Enemy;
import com.callum.zuul.model.characters.enemies.EnemySet;
import com.callum.zuul.model.items.Item;
import com.callum.zuul.model.parsers.ItemParser;
import com.callum.zuul.model.rooms.Room;
import com.callum.zuul.model.rooms.RoomSet;

import java.util.List;

/**
 * Created by callummarriage on 29/04/2018.
 */
public class MapBuilder {

    public Room start(String enemiesFile, String itemsFile, String roomsFile){
        List<RoomSet> rooms = RoomParser.readFile(roomsFile);
        List<Item> items = ItemParser.readFile(itemsFile);
        EnemySet enemies = EnemyParser.readFile(enemiesFile);
        return createRooms(rooms, items, enemies);
    }

    /**
     * Create all the rooms and link their exits together.
     */
    public Room createRooms(List<RoomSet> rooms,List<Item> items, EnemySet enemies ) {

        for(Item item : items){
            Room room =  rooms.get(0).findRandomRoom();
            room.setItem(item);
        }
        setUpEnemies(rooms.get(0), rooms.get(1), enemies);

        for(Room room : rooms.get(0).getRooms()){
            if(room.getIsStartingRoom()){
                return room;
            }
        }
        return null;
    }

    public void setUpEnemies(RoomSet normallRooms, RoomSet bossRooms, EnemySet enemies){
        for(Enemy enemy : enemies.getEnemies()){
            if(enemy instanceof BossEnemy){
                for(Room room : bossRooms.getRooms()){
                    if(room.getIsBossRoom()){
                        room.setEnemy(enemy);
                        break;
                    }
                }
            } else {
                normallRooms.findRandomRoom().setEnemy(enemy);
            }
        }
    }
}
