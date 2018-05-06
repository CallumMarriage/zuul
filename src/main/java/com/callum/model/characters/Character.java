package com.callum.model.characters;

import com.callum.model.items.characterItems.armour.Chestplate;
import com.callum.model.items.characterItems.armour.Helmet;
import com.callum.model.items.characterItems.armour.Shield;
import com.callum.model.items.characterItems.weapons.Arrow;
import com.callum.model.items.characterItems.weapons.Bow;
import com.callum.model.items.characterItems.weapons.Weapon;

import java.util.List;

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

     Helmet getHelmet();

     Chestplate getChestplate();

     Shield getShield();

     List<Arrow> getArrows();

     void addArrow(Arrow arrow);

     Bow getBow();

     void setBow(Bow bow);

     void setArrows(List<Arrow> arrows);
}
