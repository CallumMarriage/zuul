package com.callum.model.commands.noArgCommands;

import com.callum.model.Game;
import com.callum.model.commands.noArgCommands.NoArgCommand;

/**
 * Created by callummarriage on 24/04/2018.
 */
public class QuitCommand extends NoArgCommand {

    public String getSyntax() {
        return "quit";
    }

    public boolean act(Game g) {
        return true;
    }

}
