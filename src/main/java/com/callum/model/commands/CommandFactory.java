package com.callum.model.commands;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

public class CommandFactory {
    // a constant array that holds all valid command words
    private static final String[] ALL_COMMANDS = new String[]{ "go", "quit", "help"};

    public Command createCommand(String command){
        switch (command) {
            case "go": return new GoCommand();
            case "help": return new HelpCommand(ALL_COMMANDS);
            case "quit": return new QuitCommand();
            case "look": return new LookCommand();
            case "xray": return new XrayCommand();
            default: return null;
        }
    }

}
