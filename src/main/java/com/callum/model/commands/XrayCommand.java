package com.callum.model.commands;

import com.callum.model.Game;
import com.callum.model.rooms.Room;

/**
 * Created by callummarriage on 25/04/2018.
 */
public class XrayCommand extends OneArgCommand {

    @Override
    public String getSyntax() {
        return "xray direction";
    }

    @Override
    public boolean act(Game g) {
        Room room = g.getCurrentRoom().getExit(direction);

        String desc = "In the south there is " + room.getShortDescription() + ".\n" + room.getExitString();

        System.out.println(desc);
        return false;
    }

}
