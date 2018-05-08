package com.callum.model;

import com.callum.Game;
import com.callum.model.characters.enemies.BossEnemy;
import com.callum.model.characters.enemies.Enemy;
import com.callum.model.characters.enemies.EnemySet;
import com.callum.model.characters.enemies.KnightEnemy;
import com.callum.model.commands.noArgCommands.attackCommands.SwordAttackCommand;
import com.callum.model.items.characterItems.weapons.Sword;
import com.callum.model.commands.noArgCommands.attackCommands.AttackCommand;
import com.callum.model.commands.Command;
import com.callum.model.commands.oneArgCommands.GoCommand;
import com.callum.model.items.characterItems.weapons.Weapon;
import com.callum.model.rooms.*;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by callummarriage on 27/04/2018.
 */
public class RoomTest {

    private KnightEnemy enemy;

    @Test
    public void testRoomConnect(){
        enemy = new KnightEnemy(new Sword("Steve","the sword", 10), "Steve", 200);
        Game game = null;
        try {
            game = new Game(1);
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

        assert game != null;
        game.setCurrentRoom(room);
        assertEquals("Room", game.getCurrentRoom().getShortDescription());

        Command command = new GoCommand();

        command.addArgument("north");
        command.act(game);

        assertEquals("Room2", game.getCurrentRoom().getShortDescription());
    }

    @Test
    public void testEnemy(){
        enemy = new KnightEnemy(new Sword("Steve","the sword", 10), "Steve", 200);
        Game game = null;
        try {
            game = new Game(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        NormalRoom room = new NormalRoom("Room", "Room", false, false);
        NormalRoom room2 = new NormalRoom("Room2", "Room2", false, false);

        room2.setEnemy(new BossEnemy(new Sword("Sword","the sword", 30), "Enemy", 1));
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
        Command attackCommand = new SwordAttackCommand();


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

        Weapon weapon = new Sword("Sword", "the sword", 100);
        Enemy enemy = new KnightEnemy(weapon, "steve", 100);
        Weapon weapon1 = new Sword("Sword", "the sword", 100);
        Enemy enemy1 = new KnightEnemy(weapon1, "barry", 100);
        Weapon weapon2 = new Sword("Sword", "the sword", 100);
        Enemy enemy2 = new KnightEnemy(weapon2, "henry", 100);
        Weapon weapon3 = new Sword("Sword", "the sword", 100);
        Enemy enemy3 = new BossEnemy(weapon3, "clive", 100);


        enemySet.addEnemy(enemy);
        enemySet.addEnemy(enemy1);
        enemySet.addEnemy(enemy2);
        enemySet.addEnemy(enemy3);

        RoomSet bossRoomSet = new RoomSet();

        Room bossRoom = new NormalRoom("Boss", "boss", true, true);
        bossRoom.setEnemy(new BossEnemy(new Sword("sword", "sword", 100), "boss", 100));
        bossRoomSet.addRoom(bossRoom);
        mapBuilder.setUpEnemies(roomSet, bossRoomSet, enemySet);

        for(Room newRoom : roomSet.getRooms()){
            if(newRoom.getEnemy() != null){
                System.out.println(newRoom.getEnemy().getName());
            } else {
                System.out.println("The room " + newRoom.getName() + " is empty");
            }
        }

        assertEquals(100, bossRoomSet.getRooms().get(0).getEnemy().getHealth());

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
