package com.callum.zuul;

import com.callum.zuul.model.MapBuilder;
import com.callum.zuul.model.characters.Character;
import com.callum.zuul.model.containers.Container;
import com.callum.zuul.model.parsers.CommandParser;
import com.callum.zuul.model.characters.player.Player;
import com.callum.zuul.model.commands.Command;
import com.callum.zuul.model.parsers.PlayerSelection;
import com.callum.zuul.model.parsers.jsonParsers.CharacterParser;
import com.callum.zuul.model.parsers.jsonParsers.LevelParser;
import com.callum.zuul.model.rooms.*;

import java.util.List;

import static com.callum.zuul.model.constants.FileConstants.*;
import static com.callum.zuul.model.constants.BigWords.*;

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

    /**
     * Create the game and initialise its internal map.
     */
    public Application() throws Exception {
        boolean playerSelected = false;
        currentPlayer = null;

        List<Character> characters = CharacterParser.readFile(CHARACTER_FILE);

        System.out.print("Please select one of the following characters: ");

        for(int i = 0; i < characters.size(); i++){
            System.out.print(characters.get(i).getName());
            if(i !=characters.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println("\n");

        while(!playerSelected){

            PlayerSelection playerSelection = new PlayerSelection();
            String type = playerSelection.selectCharacter();

            if(type!= null) {
                playerSelected = selectPlayer(type, characters);
            }
        }
    }

    /**
     * Main method to start the game outside BlueJ
     */
    public static void main(String[] args) {
        try {
            Application g = null;
         //   g = new Application(Integer.parseInt(args[0]));
            g = new Application();
            printWelcome();

            g.play();

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

    public void setCurrentRoom(Room newRoom){
        this.currentRoom = newRoom;
    }

    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void loadLevel(Integer level) throws Exception {
        System.out.println();
        MapBuilder mapBuilder = new MapBuilder();
        Room room = mapBuilder.start(LEVEL_CONTENT_FILE+level+"/enemies.json", LEVEL_CONTENT_FILE+level+"/items.json", LEVEL_CONTENT_FILE+level+"/rooms.json");
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
    private void play() throws Exception {

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        List<Container> chapters = LevelParser.readFile(CHAPTERS_FILE);
        for(Container chapter : chapters) {
            System.out.println("<>-------<===> " + chapter.getName() + " <===>-------<>\n");
            System.out.println(chapter.getDescription() + "\n");
            System.out.println("<----------------------------------------------------------->\n");
            List<Container> levels = LevelParser.readFile(LEVELS_FILE + chapter.getNumber() + ".json");

            for(Container level : levels) {
                System.out.println("<>----<> Welcome to " + level.getName() + " <>----<>\n");
                System.out.println(level.getDescription() +"\n");
                System.out.println("<------------------------------------>\n");

                loadLevel(level.getNumber());
                boolean finished = false;
                while (!finished) {
                    Command command = CommandParser.getCommand();
                    if (command != null) {
                        finished = command.act(this);
                    }
                }
                System.out.println( LEVEL_COMPLETED);
            }
            System.out.println(this);
        }

        System.out.println(YOU_WIN);

        System.out.println("Your score was: " + getCurrentPlayer().getScore() +"\nThank you for playing.  Good bye.");
    }

    private boolean selectPlayer(String type, List<Character> characters){
        for(Character character : characters){
            if(type.equals(character.getName())){
                currentPlayer = (Player) character;
                return true;
            }
        }
        System.out.println("Please select a character from the above choices!");
        return false;
    }
    /**
     * Print out the opening message for the player.
     */
    private static void printWelcome() {
        System.out.println();
        System.out.println(GAME_OF_ZUUL);
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("Bruh.. this shit is dope.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
    }
}

