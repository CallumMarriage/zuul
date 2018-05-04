package com.callum.model.commands.noArgCommands;

import com.callum.model.Game;
import com.callum.model.items.characterItems.CharacterItem;

import java.util.List;


/**
 * Created by callummarriage on 04/05/2018.
 */
public class CharacterCommand extends NoArgCommand {
    @Override
    public boolean act(Game g) {
        List<CharacterItem> assignedItems = g.getCurrentPlayer().getAssignedItems();
        System.out.println("YOUR CHARACTER");

        if(g.getCurrentPlayer().getWeapon() != null){
            System.out.println("Weapon : " + g.getCurrentPlayer().getWeapon().getBasicInfo());
        } else {
            System.out.println("Weapon : EMPTY");
        }

        if(g.getCurrentPlayer().getHelmet() != null){
            System.out.println("Helmet : " + g.getCurrentPlayer().getHelmet().getBasicInfo());
        } else {
            System.out.println("Helmet : EMPTY");
        }

        if(g.getCurrentPlayer().getChestplate() != null){
            System.out.println("Chestplate : " + g.getCurrentPlayer().getChestplate().getBasicInfo());
        } else {
            System.out.println("Chestplate : EMPTY");
        }

        if(g.getCurrentPlayer().getShield() != null){
            System.out.println("Shield : " + g.getCurrentPlayer().getShield().getBasicInfo());
        } else {
            System.out.println("Shield : EMPTY");
        }
        return false;
    }
}
