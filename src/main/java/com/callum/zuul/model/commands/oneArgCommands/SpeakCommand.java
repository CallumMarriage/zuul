package com.callum.zuul.model.commands.oneArgCommands;

import com.callum.zuul.Application;

/**
 * Created by callummarriage on 05/05/2018.
 */
public class SpeakCommand extends OneArgCommand {
    public SpeakCommand(){

    }

    public String getSyntax() {
        return "go direction";
    }

    public boolean act(Application g){
        g.getCurrentPlayer().speak(this.arg);
        return false;
    }

}
