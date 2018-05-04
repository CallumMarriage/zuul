package com.callum.model.commands.oneArgCommands;

import com.callum.model.Game;

/**
 * Created by callummarriage on 01/05/2018.
 */
public class ChangeWeaponCommand extends OneArgCommand {


    @Override
    public String getSyntax() {

        return "change weapon";
    }

    @Override
    public boolean act(Game g){
        g.getCurrentPlayer().changeWeapons(this.arg);
        return false;
    }
}