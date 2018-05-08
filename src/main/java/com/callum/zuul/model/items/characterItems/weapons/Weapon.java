package com.callum.zuul.model.items.characterItems.weapons;

import com.callum.zuul.model.items.characterItems.CharacterItem;

/**
 * Created by callummarriage on 01/05/2018.
 */
public interface Weapon extends CharacterItem {
    Integer getDamage();

    int getWeaponHealth();

    void setWeaponHealth(int weaponHealth);
}
