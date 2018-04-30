package com.callum.model.items;

import com.callum.model.characters.Character;

/**
 * Created by callummarriage on 26/04/2018.
 */
public interface Item {

    public boolean isActive();

    public void setActive(boolean inActive);

    public String giveDescription();

    public String getName();

    public String getLongDescription();

    public Integer act(Character character);
}
