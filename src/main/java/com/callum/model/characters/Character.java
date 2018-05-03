package com.callum.model.characters;

import com.callum.model.items.characterItems.weapons.Weapon;

/**
 * Created by callummarriage on 26/04/2018.
 */
public interface Character {

     boolean attack(Character opponent);

     void speak(String command);

     String getName();

     int getHealth();

     void setHealth(Integer health);

     boolean getDead();

     void kill();

     Weapon getWeapon();

    boolean deflectAttack();
}
