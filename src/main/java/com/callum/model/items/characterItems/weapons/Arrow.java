package com.callum.model.items.characterItems.weapons;

import com.callum.model.characters.Character;

/**
 * Created by callummarriage on 06/05/2018.
 */
public class Arrow extends AbstractWeapon {

    public Arrow(String name, String description, int maxDamage) {
        super(name, description, maxDamage);
    }

    @Override
    public Integer act(Character character) {
        return null;
    }
}
