package com.callum.zuul.model.parsers;

import com.callum.zuul.model.commands.Command;
import com.callum.zuul.model.commands.factory.CommandFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by callummarriage on 08/05/2018.
 */
public class PlayerSelection {
    public String selectCharacter() {

        String inputLine = "";   // will hold the full input line
        String word1;

        System.out.print("> ");     // print prompt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println ("There was an error during reading: "
                    + exc.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // get first word
        else
            word1 = null;

        if(word1 == null){
            System.out.println("Please enter a command!");
            return null;
        }

        return word1;
    }
}
