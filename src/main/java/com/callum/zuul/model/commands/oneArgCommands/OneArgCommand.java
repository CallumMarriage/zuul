package com.callum.zuul.model.commands.oneArgCommands;

import com.callum.zuul.Application;
import com.callum.zuul.model.commands.Command;

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
    public boolean act(Application g) {
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
