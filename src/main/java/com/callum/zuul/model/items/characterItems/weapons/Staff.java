package com.callum.zuul.model.items.characterItems.weapons;

/**
 * Created by callummarriage on 01/05/2018.
 */
public class Staff extends AbstractWeapon {

    public Staff(String name, String description, int maxDamage) {
        super(name, description, maxDamage);
        weaponHealth = 100;
    }
}
