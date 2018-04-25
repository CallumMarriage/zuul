package com.callum.model.commands;

import com.callum.model.Game;

/**
 * Created by callummarriage on 25/04/2018.
 */
public class LookCommand extends NoArgCommand {

    @Override
    public String getSyntax() {
        return "look";
    }

    @Override
    public boolean act(Game g) {
        System.out.println(g.getCurrentRoom().getLongDescription());
        return false;
    }
}
