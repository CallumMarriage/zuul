package com.callum.model.commands.noArgCommands.attackCommands;

import com.callum.Game;

/**
 * Created by callummarriage on 06/05/2018.
 */
public class FireCommand extends AttackCommand {
    public FireCommand(){

    }

    public String getSyntax(){
        return "fire";
    }

   @Override
    public boolean act(Game g){
        return attack(g, "fire");
   }
}
