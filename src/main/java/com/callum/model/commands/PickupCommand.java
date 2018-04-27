package com.callum.model.commands;

import com.callum.model.Game;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class PickupCommand extends NoArgCommand{
    @Override
    public String getSyntax() {
        return "pickup";
    }

    @Override
    public boolean act(Game g){
        g.getCurrentPlayer().pickUpKey(g.getCurrentRoom().getItem());
        return false;
    }
}
