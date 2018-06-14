package com.callum.zuul.model.items.GeneratedItems;

import com.callum.zuul.model.characters.Character;
import com.callum.zuul.model.items.AbstractItem;

/**
 * Created by callummarriage on 13/06/2018.
 */
public class Spell extends AbstractItem{
    public Spell(String name, String description) {
        super(name, description);
    }

    @Override
    public Integer act(Character character) {
        return null;
    }
}
