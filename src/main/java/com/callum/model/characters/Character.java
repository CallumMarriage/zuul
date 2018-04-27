package com.callum.model.characters;

/**
 * Created by callummarriage on 26/04/2018.
 */
public interface Character {

    public void attack(Character opponent);

    public void speak(String command);

    public String getName();

    public int getHealth();

    public void setHealth(Integer health);

    public boolean getDead();

    public void kill();
}
