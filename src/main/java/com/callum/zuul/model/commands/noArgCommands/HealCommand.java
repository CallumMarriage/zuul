package com.callum.zuul.model.commands.noArgCommands;

import com.callum.zuul.Application;

/**
 * Created by callummarriage on 29/04/2018.
 */
public class HealCommand extends NoArgCommand {

    public HealCommand(){

    }

    public boolean act(Application g){
        g.getCurrentPlayer().heal();
        return false;
    }
}
