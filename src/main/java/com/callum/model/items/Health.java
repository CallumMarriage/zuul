package com.callum.model.items;

import com.callum.model.characters.Character;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class Health extends AbstractItem {

    private int value;

    public Health(String name, String description, int value){
        super(name, description);
        this.value = value;
    }

    public int getValue(){
        return value;
    }


    @Override
    public Integer act(Character character) {
        return value;
    }
}
