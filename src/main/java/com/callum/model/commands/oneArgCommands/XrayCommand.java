package com.callum.model.commands.oneArgCommands;

import com.callum.Game;
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
        Room room = g.getCurrentRoom().getExit(arg);

        String desc = "In the south there is " + room.getShortDescription() + ".\n" + room.getExitString();

        System.out.println(desc);
        return false;
    }

}
