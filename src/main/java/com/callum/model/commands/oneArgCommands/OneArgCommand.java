package com.callum.model.commands.oneArgCommands;

import com.callum.model.Game;
import com.callum.model.commands.Command;

/**
 * Created by callummarriage on 25/04/2018.
 */
public class OneArgCommand implements Command {

    protected String arg;

    @Override
    public int getNumberArgument() {
        return 1;
    }

    @Override
    public String getSyntax() {

        return null;
    }

    @Override
    public boolean act(Game g) {
        return false;
    }

    @Override
    public void addArgument(String arg) {
        if(arg.split(" ").length == 1){
            this.arg = arg;
        } else {
            System.out.println("You have given an invalid argument");
        }
    }
}
