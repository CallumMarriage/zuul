package com.callum.zuul.model.commands.noArgCommands;

import com.callum.zuul.Application;
import com.callum.zuul.model.commands.Command;

/**
 * Created by callummarriage on 25/04/2018.
 */
public class NoArgCommand implements Command {
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

    }

    public String createTitle(String title){
        return "<------------| " + title +" |------------>";
    }
}
