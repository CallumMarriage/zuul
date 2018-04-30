package com.callum.model;

import com.callum.model.characters.enemies.BossEnemy;
import com.callum.model.characters.enemies.Enemy;
import com.callum.model.characters.enemies.EnemySet;
import com.callum.model.characters.enemies.KnightEnemy;
import com.callum.model.items.Weapon;
import com.callum.model.commands.AttackCommand;
import com.callum.model.commands.Command;
import com.callum.model.commands.GoCommand;
import com.callum.model.rooms.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by callummarriage on 27/04/2018.
 */
public class RoomTest {

    private KnightEnemy enemy;

    @Test
    public void testAreaConnect(){

    }

    @Test
    public void testRoomConnect(){
        enemy = new KnightEnemy(new Weapon("Steve","the sword", 10), "Steve", 200);
        Game game = null;
        try {
            game = new Game();
        } catch (Exception e) {
            e.printStackTrace();
        }
        NormalRoom room = new NormalRoom("Room", "Room", false, false);
        NormalRoom room2 = new NormalRoom("Room2", "Room2", false, false);

        try {
            room.joinRooms("north", room2);
        } catch (Exception e){
            e.printStackTrace();
        }

        game.setCurrentRoom(room);
        assertEquals("Room", game.getCurrentRoom().getShortDescription());

        Command command = new GoCommand();

        command.addArgument("north");
        command.act(game);

        assertEquals("Room2", game.getCurrentRoom().getShortDescription());
    }

    @Test
    public void testEnemy(){
        enemy = new KnightEnemy(new Weapon("Steve","the sword", 10), "Steve", 200);
        Game game = null;
        try {
            game = new Game();
        } catch (Exception e) {
            e.printStackTrace();
        }

        NormalRoom room = new NormalRoom("Room", "Room", false, false);
        NormalRoom room2 = new NormalRoom("Room2", "Room2", false, false);

        room2.setEnemy(new BossEnemy(new Weapon("Sword","the sword", 30), "Enemy", 10));
        try {
            room.joinRooms("north", room2);
        } catch (Exception e){
            e.printStackTrace();
        }
        game.setCurrentRoom(room);
        assertEquals("Room", game.getCurrentRoom().getShortDescription());

        Command command = new GoCommand();

        command.addArgument("north");
        command.act(game);
        assertEquals("Room2", game.getCurrentRoom().getShortDescription());

        System.out.println(game.getCurrentPlayer().getName());
        Command attackCommand = new AttackCommand();


        attackCommand.act(game);
        attackCommand.act(game);
        attackCommand.act(game);
        System.out.println(game.getCurrentRoom().getEnemy().getHealth());
        assertTrue(game.getCurrentRoom().getEnemy().getDead());

        Command goCommand2 = new GoCommand();
        goCommand2.addArgument("south");
        goCommand2.act(game);

        command.act(game);
    }

    @Test
    public void testRoomBuilder(){
        MapBuilder mapBuilder = new MapBuilder();
        RoomSet roomSet = new RoomSet();
        Room room = new NormalRoom("room", "this room", false, false);
        Room room1 = new NormalRoom("room1", "this room", false, false);
        Room room2 = new NormalRoom("room2", "this room", false, false);
        Room room3 = new NormalRoom("room3", "this room", false, false);
        Room room4 = new NormalRoom("room4", "this room", false, true);

        Room room5 = new NormalRoom("room", "this room", false, false);
        Room room6 = new NormalRoom("room1", "this room", false, false);
        Room room7 = new NormalRoom("room2", "this room", false, false);
        Room room8 = new NormalRoom("room3", "this room", false, false);
        Room room9 = new NormalRoom("room4", "this room", false, true);

        Room room10 = new NormalRoom("room", "this room", false, false);
        Room room11 = new NormalRoom("room1", "this room", false, false);
        Room room12 = new NormalRoom("room2", "this room", false, false);
        Room room13 = new NormalRoom("room3", "this room", false, false);
        Room room14 = new NormalRoom("room4", "this room", false, true);


        roomSet.addRoom(room);
        roomSet.addRoom(room1);
        roomSet.addRoom(room2);
        roomSet.addRoom(room3);
        roomSet.addRoom(room4);

        roomSet.addRoom(room5);
        roomSet.addRoom(room6);
        roomSet.addRoom(room7);
        roomSet.addRoom(room8);
        roomSet.addRoom(room9);

        roomSet.addRoom(room10);
        roomSet.addRoom(room11);
        roomSet.addRoom(room12);
        roomSet.addRoom(room13);
        roomSet.addRoom(room14);
        assertEquals(3, mapBuilder.buildAreas(roomSet).size());

    }

    @Test
    public void testRoomConnections(){
        MapBuilder mapBuilder = new MapBuilder();

        RoomSet roomSet = new RoomSet();
        Room room = new NormalRoom("room", "A", false, false);
        Room room1 = new NormalRoom("room1", "B", false, false);
        Room room2 = new NormalRoom("room2", "C", false, false);
        Room room3 = new NormalRoom("room3", "D", false, false);
        Room room4 = new NormalRoom("room4", "E", false, true);

        roomSet.addRoom(room);
        roomSet.addRoom(room1);
        roomSet.addRoom(room2);
        roomSet.addRoom(room3);
        roomSet.addRoom(room4);

        Area area = mapBuilder.groupRoomsAsArea(roomSet);

        RoomSet roomSet2 = new RoomSet();
        Room rooma = new NormalRoom("room", "F", false, false);
        Room roomb = new NormalRoom("room1", "G", false, false);
        Room roomc = new NormalRoom("room2", "H", false, false);
        Room roomd = new NormalRoom("room3", "I", false, false);
        Room roome = new NormalRoom("room4", "J", false, true);

        roomSet2.addRoom(rooma);
        roomSet2.addRoom(roomb);
        roomSet2.addRoom(roomc);
        roomSet2.addRoom(roomd);
        roomSet2.addRoom(roome);

        Area area2 = mapBuilder.groupRoomsAsArea(roomSet2);

        try {
            if(mapBuilder.connectTwoAreas(area, area2) == false) {
                System.out.println("FAILURE");
            } else {

                System.out.println("Central rooms");
                System.out.println(area.getCentralRoom().getExitString());
                System.out.println(area2.getCentralRoom().getExitString());
                System.out.println("\n");

                System.out.println("East rooms");
                System.out.println(area.getEastRoom().getExitString());
                System.out.println(area2.getEastRoom().getExitString());
                System.out.println("\n");

                System.out.println("West rooms");
                System.out.println(area.getWestRoom().getExitString());
                System.out.println(area2.getWestRoom().getExitString());
                System.out.println("\n");

                System.out.println("North rooms");
                System.out.println(area.getNorthRoom().getExitString());
                System.out.println(area2.getNorthRoom().getExitString());
                System.out.println("\n");

                System.out.println("South rooms");
                System.out.println(area.getSouthRoom().getExitString());
                System.out.println(area2.getSouthRoom().getExitString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGroupRoomsAsArea(){
        MapBuilder mapBuilder = new MapBuilder();

        RoomSet roomSet = new RoomSet();
        Room room = new NormalRoom("room", "this room", false, false);
        Room room1 = new NormalRoom("room1", "this room", false, false);
        Room room2 = new NormalRoom("room2", "this room", false, false);
        Room room3 = new NormalRoom("room3", "this room", false, false);
        Room room4 = new NormalRoom("room4", "this room", false, true);

        roomSet.addRoom(room);
        roomSet.addRoom(room1);
        roomSet.addRoom(room2);
        roomSet.addRoom(room3);
        roomSet.addRoom(room4);

        Area area = mapBuilder.groupRoomsAsArea(roomSet);


        assertEquals(5, area.getAllRooms().getRooms().size());
    }

    @Test
    public void testEnemySetup(){
        MapBuilder mapBuilder = new MapBuilder();
        RoomSet roomSet = new RoomSet();
        Room room = new NormalRoom("room", "this room", false, false);
        Room room1 = new NormalRoom("room1", "this room", false, false);
        Room room2 = new NormalRoom("room2", "this room", false, false);
        Room room3 = new NormalRoom("room3", "this room", false, false);
        Room room4 = new NormalRoom("room4", "this room", false, true);

        roomSet.addRoom(room);
        roomSet.addRoom(room1);
        roomSet.addRoom(room2);

        EnemySet enemySet = new EnemySet();

        Weapon weapon = new Weapon("Sword", "the sword", 100);
        Enemy enemy = new KnightEnemy(weapon, "steve", 100);
        Weapon weapon1 = new Weapon("Sword", "the sword", 100);
        Enemy enemy1 = new KnightEnemy(weapon1, "barry", 100);
        Weapon weapon2 = new Weapon("Sword", "the sword", 100);
        Enemy enemy2 = new KnightEnemy(weapon2, "henry", 100);
        Weapon weapon3 = new Weapon("Sword", "the sword", 100);
        Enemy enemy3 = new BossEnemy(weapon3, "clive", 100);


        enemySet.addEnemy(enemy);
        enemySet.addEnemy(enemy1);
        enemySet.addEnemy(enemy2);
        enemySet.addEnemy(enemy3);

        mapBuilder.setUpEnemies(roomSet, enemySet);

        for(Room newRoom : roomSet.getRooms()){
            if(newRoom.getEnemy() != null){
                System.out.println(newRoom.getEnemy().getName());
            } else {
                System.out.println("The room " + newRoom.getName() + " is empty");
            }
        }

        roomSet.addRoom(room3);
        roomSet.addRoom(room4);

        System.out.println("\n");

        for(Room newRoom : roomSet.getRooms()){
            if(newRoom.getEnemy() != null){
                System.out.println(newRoom.getEnemy().getName());
            } else {
                System.out.println("The room " + newRoom.getName() + " is empty");
            }
        }

    }
}
