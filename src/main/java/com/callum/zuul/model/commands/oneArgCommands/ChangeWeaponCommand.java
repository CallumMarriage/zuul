package com.callum.zuul.model.commands.oneArgCommands;

import com.callum.zuul.Application;

/**
 * Created by callummarriage on 01/05/2018.
 */
public class ChangeWeaponCommand extends OneArgCommand {


    @Override
    public String getSyntax() {

        return "change weapon";
    }

    @Override
    public boolean act(Application g){
        g.getCurrentPlayer().changeCharacterItem(this.arg);
        return false;
    }
}
