package com.callum.model.commands.oneArgCommands;

import com.callum.Game;

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
        g.getCurrentPlayer().changeCharacterItem(this.arg);
        return false;
    }
}
