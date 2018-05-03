package com.callum.model.items.characterItems;

import com.callum.model.characters.Character;
import com.callum.model.items.AbstractItem;

/**
 * Created by callummarriage on 02/05/2018.
 */
public abstract class AbstractCharacterItem extends AbstractItem implements CharacterItem{

    private boolean isEquipped;

    public AbstractCharacterItem(String name, String description) {
        super(name, description);
    }

    @Override
    public abstract Integer act(Character character);

    @Override
    public boolean getIsEquipped(){
        return this.isEquipped;
    }

    @Override
    public void setEquipped(Boolean equipped){
        this.isEquipped = equipped;
    }
}
