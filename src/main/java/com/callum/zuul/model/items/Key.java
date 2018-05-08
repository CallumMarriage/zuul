package com.callum.zuul.model.items;

import com.callum.zuul.model.characters.Character;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class Key extends AbstractItem {

    private String room;

    public Key(String name, String description, String room){
        super(name, description);
        this.room = room;
    }

    public String getRoom(){
        return room;
    }

    @Override
    public Integer act(Character character) {
        return null;
    }
}
