package com.callum.model.commands.noArgCommands;

import com.callum.model.Game;

/**
 * Created by callummarriage on 29/04/2018.
 */
public class HealCommand extends NoArgCommand {

    public HealCommand(){

    }

    public boolean act(Game g){
        g.getCurrentPlayer().heal();
        return false;
    }
}
