package com.callum.model.commands.noArgCommands;

import com.callum.model.Game;
import com.callum.model.commands.Command;

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
    public boolean act(Game g) {
        return false;
    }

    @Override
    public void addArgument(String arg) {

    }
}