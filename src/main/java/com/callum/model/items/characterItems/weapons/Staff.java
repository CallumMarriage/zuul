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
}
