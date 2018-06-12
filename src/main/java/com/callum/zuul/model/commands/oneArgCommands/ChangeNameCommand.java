package com.callum.zuul.model.commands.oneArgCommands;

import com.callum.zuul.Application;

/**
 * Created by callummarriage on 29/05/2018.
 */
public class ChangeNameCommand extends OneArgCommand {

    @Override
    public String getSyntax() {
        return "change weapon";
    }

    @Override
    public boolean act(Application g){
        g.getCurrentPlayer().setName(arg);
        System.out.println("Changed name to " + g.getCurrentPlayer().getName());
        return false;
    }
}
