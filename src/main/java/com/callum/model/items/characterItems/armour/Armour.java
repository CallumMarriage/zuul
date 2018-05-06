package com.callum.model.items.characterItems.armour;

import com.callum.model.items.characterItems.CharacterItem;

/**
 * Created by callummarriage on 02/05/2018.
 */
public interface Armour extends CharacterItem {

    Integer getValue();

    void setValue(Integer value);

    boolean deflect();
}
