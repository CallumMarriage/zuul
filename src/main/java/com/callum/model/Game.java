package com.callum.model;

import com.callum.model.commands.Command;
import com.callum.model.rooms.NormalRoom;
import com.callum.model.rooms.Room;
import com.callum.model.rooms.RoomSet;
import com.callum.model.rooms.TransporterRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office, club;
      
        // create the rooms
        outside = new NormalRoom("outside the main entrance of the university");
        theatre = new NormalRoom("a lecture theatre");
        pub = new NormalRoom("the campus pub");
        lab = new NormalRoom("a computing lab");
        office = new NormalRoom("the computing admin office");
        TransporterRoom transporterRoom = new TransporterRoom("the Transporter Room");
        club = new NormalRoom("The club");

        RoomSet roomSet = new RoomSet(new Random(5));

        // initialise room exits
	    outside.joinRooms("east", theatre);
        outside.joinRooms("south", lab);
        outside.joinRooms("west", pub);
        outside.joinRooms("north", transporterRoom);
        outside.joinRooms("north", club);

        lab.joinRooms("east", office);
        roomSet.addRoom(outside);
        roomSet.addRoom(theatre);
        roomSet.addRoom(pub);
        roomSet.addRoom(lab);
        roomSet.addRoom(office);
        transporterRoom.setRoomSet(roomSet);
        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
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
    private void printWelcome()
    {
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
}

