package com.callum.model.commands.noArgCommands;

import com.callum.model.Game;
import com.callum.model.commands.noArgCommands.NoArgCommand;

/**
 * Created by callummarriage on 30/04/2018.
 */
public class StatsCommand extends NoArgCommand {

    @Override
    public boolean act(Game g){
        StringBuilder sb = new StringBuilder();
        sb.append("Health:  ");
        sb.append(g.getCurrentPlayer().getHealth());
        sb.append("\nDamage:  ");
        sb.append( g.getCurrentPlayer().getWeapon().getDamage());
        sb.append("\nArmour:  ");
        sb.append(g.getCurrentPlayer().getArmour());
        sb.append("\nScore:   ");
        sb.append(g.getCurrentPlayer().getScore());
        System.out.println(sb.toString());
        return false;
    }
}
