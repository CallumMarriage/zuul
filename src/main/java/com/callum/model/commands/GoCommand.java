package com.callum.model.commands;

import com.callum.model.Game;
import com.callum.model.rooms.Room;

/**
 * Created by callummarriage on 24/04/2018.
 */
public class GoCommand extends OneArgCommand {


    public GoCommand(){

    }


    public String getSyntax() {
        return "go direction";
    }

    public boolean act(Game g){
        if(g.getCurrentRoom().getExit(direction)!= null){
            g.setCurrentRoom(g.getCurrentRoom().getExit(direction));
            System.out.println(g.getCurrentRoom().getLongDescription());
        } else{
            System.out.println("You cant go that way you idiot!!");

        }
        return false;
    }

}
