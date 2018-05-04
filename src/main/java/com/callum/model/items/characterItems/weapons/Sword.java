package com.callum.model.items.characterItems.weapons;

import com.callum.model.characters.Character;

import java.security.SecureRandom;

/**
 * Created by callummarriage on 01/05/2018.
 */
public class Sword extends AbstractWeapon {
    public Sword(String name, String description, int maxDamage) {
        super(name, description, maxDamage);
        weaponHealth = 60;
    }

    @Override
    public Integer act(Character character) {
        SecureRandom rand = new SecureRandom();
        int i = rand.nextInt(maxDamage) + 1;
        if(character.deflectAttack()){
            return 0;
        } else {
            character.setHealth(character.getHealth() - i);
        }
        return i;
    }
}
