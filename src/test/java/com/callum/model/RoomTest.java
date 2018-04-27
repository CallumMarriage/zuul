package com.callum.model;

import com.callum.model.characters.enemies.BossEnemy;
import com.callum.model.characters.enemies.KnightEnemy;
import com.callum.model.characters.weapons.Weapon;
import com.callum.model.commands.AttackCommand;
import com.callum.model.commands.Command;
import com.callum.model.commands.GoCommand;
import com.callum.model.rooms.NormalRoom;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.security.SecureRandom;

/**
 * Created by callummarriage on 27/04/2018.
 */
public class RoomTest {

    private KnightEnemy enemy;

    @Before
    public void before(){
        enemy = new KnightEnemy(new Weapon("Steve", 10), "Steve", 200);
    }

    @Test
    public void testRoomConnect(){

        Game game = new Game();
        NormalRoom room = new NormalRoom("Room", false);
        NormalRoom room2 = new NormalRoom("Room2", false);

        room.joinRooms("north", room2);

        game.setCurrentRoom(room);
        assertEquals("Room", game.getCurrentRoom().getShortDescription());

        Command command = new GoCommand();

        command.addArgument("north");
        command.act(game);

        assertEquals("Room2", game.getCurrentRoom().getShortDescription());
    }

    @Test
    public void testEnemy(){
        Game game = new Game();

        NormalRoom room = new NormalRoom("Room", false);
        NormalRoom room2 = new NormalRoom("Room2", false);

        room2.setEnemy(new BossEnemy(new Weapon("Sword", 30), "Enemy", 10));
        room.joinRooms("north", room2);

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
}
