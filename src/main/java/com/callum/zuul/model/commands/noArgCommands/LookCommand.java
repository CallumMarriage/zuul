package com.callum.zuul.model.commands.noArgCommands;

import com.callum.zuul.Application;

/**
 * Created by callummarriage on 25/04/2018.
 */
public class LookCommand extends NoArgCommand {

    @Override
    public String getSyntax() {
        return "look";
    }

    @Override
    public boolean act(Application g) {
        System.out.println(g.getCurrentRoom().getLongDescription());
        return false;
    }
}
