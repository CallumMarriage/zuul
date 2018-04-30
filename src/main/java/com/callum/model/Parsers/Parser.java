package com.callum.model.Parsers;
import com.callum.model.commands.Command;
import com.callum.model.commands.CommandFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

public class Parser {


    public Parser() 
    {

    }

    public Command getCommand() {

        CommandFactory commandFactory = new CommandFactory();


        String inputLine = "";   // will hold the full input line
        String word1;
        String word2;

        System.out.print("> ");     // print prompt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println ("There was an error during reading: "
                                + exc.getMessage());
        } catch (Exception e){
            System.out.println("Exception");
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // get first word
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();      // get second word
        else
            word2 = null;



        Command command = commandFactory.createCommand(word1);

        if(command != null){
            if(command.getNumberArgument() == 1){
                command.addArgument(word2);
            }
        } else {
            System.out.println("I do not recognise that command! For the commands type help");
        }

        return command;
    }
}
