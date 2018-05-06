package com.callum.model.commands.noArgCommands;

import com.callum.model.Game;

/**
 * Created by callummarriage on 24/04/2018.
 */
public class HelpCommand extends NoArgCommand {

    private String[] commands;

    public HelpCommand(String[] commands){
        this.commands = commands;
    }

    public String getSyntax() {
        return "help";
    }

    public boolean act(Game g) {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        for(String command : commands){
            System.out.println(" ");
            System.out.println(command);
        }
        return false;
    }
}
