package com.callum.model;

import com.callum.model.characters.enemies.*;
import com.callum.model.characters.player.Player;
import com.callum.model.characters.weapons.Weapon;
import com.callum.model.commands.Command;
import com.callum.model.items.Key;
import com.callum.model.rooms.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

public class Game {
    private Parser parser;
    private Room currentRoom;
    private Player currentPlayer;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        parser = new Parser();
        Weapon weapon = new Weapon("Sword", 50);
        currentPlayer = new Player(weapon, "Steve", 200);
    }


    private EnemySet generateEnemies(){

        EnemySet enemies = new EnemySet(new SecureRandom());


        File file = FileUtils.getFile("./src/main/resources/enemies.txt");

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String line = scanner.next();
                String[] lineSplit = line.split(",");
                Enemy enemy = EnemyFactory.createEnemy(lineSplit);
                enemies.addEnemy(enemy);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return enemies;
    }
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room outside, theatre, pub, lab, office, club;

        EnemySet enemies = generateEnemies();

        // create the rooms
        outside = new NormalRoom("outside the main entrance of the university", false);
        theatre = new NormalRoom("a lecture theatre", false);
        pub = new NormalRoom("the campus pub", false);
        lab = new NormalRoom("a computing lab", true);
        office = new NormalRoom("the computing admin office", false);
        TransporterRoom transporterRoom = new TransporterRoom("the Transporter Room", false);

        RoomSet roomSet = new RoomSet(new SecureRandom());

        // initialise room exits
	    outside.joinRooms("east", theatre);
        outside.joinRooms("south", lab);
        outside.joinRooms("west", pub);
        outside.joinRooms("north", transporterRoom);

        lab.joinRooms("east", office);
        lab.setEnemy(new BossEnemy( new Weapon("Staff", 50), "Paul", 100));

        roomSet.addRoom(theatre);
        roomSet.addRoom(pub);
        roomSet.addRoom(office);

        roomSet.findRandomRoom().setItem(new Key("LabKey", "Lab"));

        transporterRoom.setRoomSet(roomSet);

        Random random = new Random(20);
        for(Room room : roomSet.getRooms()){
            if(random.nextBoolean()) {
                room.setEnemy(enemies.findRandomEnemy());
            }
        }
        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {
        printWelcome();


        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            if(command != null){
                finished = command.act(this);
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Main method to start the game outside BlueJ
     */
    public static void main(String[] args) {
        Game g = new Game();
        g.play();
        System.out.println(g);
    }

    /*
     * Provide string representation
     */
    public String toString() {
	String s = "Current room is " + currentRoom;
	return s;
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    public void setCurrentRoom(Room newRoom){
        this.currentRoom = newRoom;
    }

    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}

