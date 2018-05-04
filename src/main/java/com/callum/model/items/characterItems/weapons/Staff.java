package com.callum.model.items.characterItems.weapons;

import com.callum.model.characters.Character;

import java.security.SecureRandom;

/**
 * Created by callummarriage on 01/05/2018.
 */
public class Staff extends AbstractWeapon {

    public Staff(String name, String description, int maxDamage) {
        super(name, description, maxDamage);
        weaponHealth = 100;
    }

    @Override
    public Integer act(Character character) {
        SecureRandom rand = new SecureRandom();
        int i = rand.nextInt(maxDamage) + 1;
        if(character.deflectAttack()){
            return 0;
        } else {
            int temp = 0;
            if (character.getChestplate() != null) {
                if (character.getChestplate().getValue() > 0) {
                    if (character.getChestplate().getValue() >= i) {
                        character.getChestplate().setValue(character.getChestplate().getValue() - i);
                        character.setArmour(character.getArmour() -i);
                    } else {
                        temp = i - character.getChestplate().getValue();
                        character.getChestplate().setValue(0);
                        character.setArmour(character.getArmour() - character.getChestplate().getValue());
                    }
                }
            }else if (character.getHelmet() != null) {
                if (character.getHelmet().getValue() > 0) {
                    if (character.getHelmet().getValue() >= i) {
                        character.getHelmet().setValue(character.getHelmet().getValue() - i);
                        character.setArmour(character.getArmour() -i);
                    } else {
                        temp = i - character.getHelmet().getValue();
                        character.getHelmet().setValue(0);
                        character.setArmour(character.getArmour() - character.getHelmet().getValue());
                    }
                }
            } else if(character.getShield() != null) {
                if (character.getShield().getValue() > 0) {
                    if (character.getShield().getValue() >= i) {
                        character.getShield().setValue(character.getShield().getValue() - i);
                        character.setArmour(character.getArmour() -i);
                    } else {
                        temp = i - character.getShield().getValue();
                        character.getShield().setValue(0);
                        character.setArmour(character.getArmour() - character.getShield().getValue());

                    }
                }
            } else {
                temp = i;
            }
            character.setHealth(character.getHealth() - temp);
        }
        return i;
    }
}
