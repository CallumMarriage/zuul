package com.callum.model.items.characterItems.weapons;

import com.callum.model.characters.Character;
import com.callum.model.characters.player.Player;

import java.security.SecureRandom;

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
