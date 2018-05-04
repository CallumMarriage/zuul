package com.callum.model;

import com.callum.model.Parsers.Parser;
import com.callum.model.Parsers.RoomParser;
import com.callum.model.characters.player.Player;
import com.callum.model.items.characterItems.weapons.Sword;
import com.callum.model.items.characterItems.weapons.Weapon;
import com.callum.model.commands.Command;
import com.callum.model.rooms.*;


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
    public Game() throws Exception {
        MapBuilder mapBuilder = new MapBuilder();
        Room room = mapBuilder.start();
        if(room != null){
            currentRoom = room;
        } else {
            throw new Exception("No starting Room generated");
        }
        parser = new Parser();
        Weapon weapon = new Sword("Sword","The Sword of Destiny!",  50);
        System.out.println("Starting weapon: " + weapon.getName() + ".");
        currentPlayer = new Player(weapon, "Steve", 200);
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
        System.out.println("Your score was: " + getCurrentPlayer().getScore() +"\nThank you for playing.  Good bye.");
    }

    /**
     * Main method to start the game outside BlueJ
     */
    public static void main(String[] args) {
        try {
            Game g = null;
            g = new Game();
            g.play();
            System.out.println(g);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Provide string representation
     */
    public String toString() {
        return "Current room is " + currentRoom;
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

