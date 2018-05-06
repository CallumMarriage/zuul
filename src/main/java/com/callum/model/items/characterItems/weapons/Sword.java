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
}
