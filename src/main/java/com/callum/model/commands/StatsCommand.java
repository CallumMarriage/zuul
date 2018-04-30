package com.callum.model.commands;

import com.callum.model.Game;

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
        System.out.println(sb.toString());
        return false;
    }
}
