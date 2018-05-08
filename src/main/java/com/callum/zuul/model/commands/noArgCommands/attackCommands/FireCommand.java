package com.callum.zuul.model.commands.noArgCommands.attackCommands;

import com.callum.zuul.Application;

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
    public boolean act(Application g){
        return attack(g, "fire");
   }
}
