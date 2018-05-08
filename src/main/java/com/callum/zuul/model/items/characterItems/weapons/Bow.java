package com.callum.zuul.model.items.characterItems.weapons;

import com.callum.zuul.model.characters.Character;

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

    public void fire(List<Arrow> arrows, Character character){
        if(arrows != null){
            int i = arrows.get(0).getDamage();
            character.setHealth(character.getHealth() - i);
            System.out.println("You have fired and have done " + i + " damage!");
        } else {
            System.out.println("Hmm. something went wrong.");
        }
    }
}
