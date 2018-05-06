package com.callum.model.commands.oneArgCommands;

import com.callum.Game;

/**
 * Created by callummarriage on 05/05/2018.
 */
public class SpeakCommand extends OneArgCommand {
    public SpeakCommand(){

    }

    public String getSyntax() {
        return "go direction";
    }

    public boolean act(Game g){
        g.getCurrentPlayer().speak(this.arg);
        return false;
    }

}
