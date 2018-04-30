package com.callum.model.characters;

import com.callum.model.items.Weapon;

/**
 * Created by callummarriage on 26/04/2018.
 */
public interface Character {

    public boolean attack(Character opponent);

    public void speak(String command);

    public String getName();

    public int getHealth();

    public void setHealth(Integer health);

    public boolean getDead();

    public void kill();

    public Weapon getWeapon();
}
