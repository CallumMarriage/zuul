package com.callum.zuul.model.commands.factory;

import com.callum.zuul.model.commands.*;
import com.callum.zuul.model.commands.noArgCommands.*;
import com.callum.zuul.model.commands.noArgCommands.attackCommands.FireCommand;
import com.callum.zuul.model.commands.noArgCommands.attackCommands.SwordAttackCommand;
import com.callum.zuul.model.commands.oneArgCommands.*;

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
    private static final String[] ALL_COMMANDS = new String[]{
            "go",
            "quit",
            "help",
            "attack",
            "look",
            "xray",
            "pickup",
            "heal",
            "stats",
            "pickup",
            "change",
            "inventory",
            "character",
            "fire",
            "changeName"
    };

    public Command createCommand(String command){
        switch (command) {
            case "go": return new GoCommand();
            case "help": return new HelpCommand(ALL_COMMANDS);
            case "quit": return new QuitCommand();
            case "look": return new LookCommand();
            case "xray": return new XrayCommand();
            case "attack" : return new SwordAttackCommand();
            case "pickup": return new PickupCommand();
            case "heal": return new HealCommand();
            case "stats": return new StatsCommand();
            case "change": return new ChangeWeaponCommand();
            case "inventory": return new ListItemsCommand();
            case "character": return new CharacterCommand();
            case "speak": return new SpeakCommand();
            case "fire": return new FireCommand();
            case "changeName": return new ChangeNameCommand();
            default: return null;
        }
    }

}
