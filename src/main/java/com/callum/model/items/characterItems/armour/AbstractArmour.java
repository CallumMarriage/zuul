package com.callum.model.items.characterItems.armour;

import com.callum.model.characters.Character;
import com.callum.model.items.characterItems.AbstractCharacterItem;

/**
 * Created by callummarriage on 02/05/2018.
 */
public abstract class AbstractArmour extends AbstractCharacterItem implements Armour {

    public Integer value;

    public AbstractArmour(String name, String description, Integer value) {
        super(name, description);
        this.value = value;
    }

    @Override
    public Integer act(Character character) {
        return null;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public abstract boolean deflect();

    @Override
    public void setValue(Integer value) {
        this.value = value;
    }
}
