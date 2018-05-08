package com.callum.zuul.model.commands.noArgCommands;

import com.callum.zuul.Application;
import com.callum.zuul.model.characters.player.Player;
import com.callum.zuul.model.items.characterItems.CharacterItem;
import com.callum.zuul.model.items.characterItems.armour.Armour;

/**
 * Created by callummarriage on 30/04/2018.
 */
public class StatsCommand extends NoArgCommand {

    @Override
    public boolean act(Application g){
        StringBuilder sb = new StringBuilder();
        sb.append("Health:  ");
        sb.append(g.getCurrentPlayer().getHealth());
        sb.append("\nDamage:  ");
        sb.append( g.getCurrentPlayer().getWeapon().getDamage());
        sb.append("\nArmour:  ");
        sb.append(calcArmour(g.getCurrentPlayer()));
        sb.append("\nScore:   ");
        sb.append(g.getCurrentPlayer().getScore());
        System.out.println(sb.toString());
        return false;
    }

    public int calcArmour(Player player){
        int armour= 0;

        for(CharacterItem characterItem : player.getAssignedItems()){
            if(characterItem instanceof Armour){
                armour+= ((Armour) characterItem).getValue();
            }
        }

        return armour;
    }
}
