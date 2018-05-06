package com.callum.model.items.characterItems.weapons;

import com.callum.model.characters.Character;
import com.callum.model.characters.player.Player;

import java.security.SecureRandom;
import java.util.List;

/**
 * Created by callummarriage on 01/05/2018.
 */
public class Bow extends AbstractWeapon {
    public Bow(String name, String description, int maxDamage) {
        super(name, description, maxDamage);
        weaponHealth = 30;
    }

    @Override
    public Integer act(Character character) {
        return null;
    }

    public Integer fire(List<Arrow> arrows, Character character){
        if(arrows != null){
            int i = arrows.get(0).getDamage();
            character.setHealth(character.getHealth() - i);
            System.out.println("You have fired and have done " + i + "damage!w");
            return i;

        } else {
            System.out.println("Hmm. something went wrong.");
        }
        return null;
    }
}
