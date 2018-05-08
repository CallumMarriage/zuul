package com.callum.zuul;

import com.callum.zuul.model.MapBuilder;
import com.callum.zuul.model.parsers.Parser;
import com.callum.zuul.model.characters.player.Player;
import com.callum.zuul.model.items.characterItems.weapons.Sword;
import com.callum.zuul.model.items.characterItems.weapons.Weapon;
import com.callum.zuul.model.commands.Command;
import com.callum.zuul.model.rooms.*;

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

public class Application {
    private Room currentRoom;
    private Player currentPlayer;

    public int level;
    public int numberOfLevls;

    /**
     * Create the game and initialise its internal map.
     */
    public Application(int numberOfLevls) throws Exception {
        Weapon weapon = new Sword("Sword","The Sword of Destiny!",  50);
        currentPlayer = new Player(weapon, "Steve", 200);
        level = 1;
        this.numberOfLevls = numberOfLevls;
    }

    /**
     * Main method to start the game outside BlueJ
     */
    public static void main(String[] args) {
        try {
            Application g = null;
         //   g = new Application(Integer.parseInt(args[0]));
           g = new Application(2);
            printWelcome();
            g.loadLevel();
            g.play();
            System.out.println(g);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadLevel() throws Exception {
        System.out.println("LEVEL " + level);
        System.out.println();
        MapBuilder mapBuilder = new MapBuilder();
        Room room = mapBuilder.start("./src/main/resources/enemies/enemies-"+level+".json", "./src/main/resources/items/items-"+level+".json", "./src/main/resources/rooms/rooms-"+level+".json");
        if(room != null){
            currentRoom = room;
        } else {
            throw new Exception("No starting Room generated");
        }

        System.out.println(currentRoom.getLongDescription());
        System.out.println("Starting weapon: " + getCurrentPlayer().getWeapon().getName() + ".");
        System.out.println();
        if(currentRoom.getEnemy() == null){
            System.out.println("\nIt is empty, you may move on");
        } else if(!currentRoom.getEnemy().getDead()){
            System.out.println(currentRoom.getEnemy().getDescription());
        }
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = Parser.getCommand();
            if(command != null){
                finished = command.act(this);
            }
        }
        System.out.println("Your score was: " + getCurrentPlayer().getScore() +"\nThank you for playing.  Good bye.");
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
    private static void printWelcome() {
        System.out.println();
        System.out.println("" +
                "   ▄██████▄     ▄████████   ▄▄▄▄███▄▄▄▄      ▄████████       ▄██████▄     ▄████████       ▄███████▄  ███    █▄  ███    █▄   ▄█       \n" +
                "  ███    ███   ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███      ███    ███   ███    ███      ██▀     ▄██ ███    ███ ███    ███ ███       \n" +
                "  ███    █▀    ███    ███ ███   ███   ███   ███    █▀       ███    ███   ███    █▀             ▄███▀ ███    ███ ███    ███ ███       \n" +
                " ▄███          ███    ███ ███   ███   ███  ▄███▄▄▄          ███    ███  ▄███▄▄▄           ▀█▀▄███▀▄▄ ███    ███ ███    ███ ███       \n" +
                "▀▀███ ████▄  ▀███████████ ███   ███   ███ ▀▀███▀▀▀          ███    ███ ▀▀███▀▀▀            ▄███▀   ▀ ███    ███ ███    ███ ███       \n" +
                "  ███    ███   ███    ███ ███   ███   ███   ███    █▄       ███    ███   ███             ▄███▀       ███    ███ ███    ███ ███       \n" +
                "  ███    ███   ███    ███ ███   ███   ███   ███    ███      ███    ███   ███             ███▄     ▄█ ███    ███ ███    ███ ███▌    ▄ \n" +
                "  ████████▀    ███    █▀   ▀█   ███   █▀    ██████████       ▀██████▀    ███              ▀████████▀ ████████▀  ████████▀  █████▄▄██ \n" +
                "                                                                                                                           ▀         ");
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("Bruh.. this shit is dope.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}

