package com.callum.model.commands.noArgCommands;

import com.callum.model.Game;
import com.callum.model.characters.player.Player;
import com.callum.model.items.characterItems.CharacterItem;
import com.callum.model.items.characterItems.armour.Armour;

import java.util.List;


/**
 * Created by callummarriage on 04/05/2018.
 */
public class CharacterCommand extends NoArgCommand {
    @Override
    public boolean act(Game g) {
        System.out.println("YOUR CHARACTER");
        Player player = g.getCurrentPlayer();

        if(player.getWeapon() != null){
            System.out.println("Weapon : " + player.getWeapon().getCharacterItemsAndValues());
        } else {
            System.out.println("Weapon : EMPTY");
        }

        if(player.getHelmet() != null){
            System.out.println("Helmet : " + player.getHelmet().getCharacterItemsAndValues() + checkIfBroken(player.getHelmet()));
        } else {
            System.out.println("Helmet : EMPTY");
        }

        if(player.getChestplate() != null){
            System.out.println("Chestplate : " + player.getChestplate().getCharacterItemsAndValues() + checkIfBroken(player.getChestplate()));
        } else {
            System.out.println("Chestplate : EMPTY");
        }

        if(player.getShield() != null){
            System.out.println("Shield : " + player.getShield().getCharacterItemsAndValues() + checkIfBroken(player.getShield()));
        } else {
            System.out.println("Shield : EMPTY");
        }
        return false;
    }

    public String checkIfBroken(Armour armour){
        if(armour.getValue() <= 0){
            return " (Broken)";
        } else {
            return "";
        }
    }

    @Override
    public String getSyntax(){
        return "character";
    }
}
