package com.callum.model.items;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class Key extends AbstractItem {

    private String room;

    public Key(String name, String room){
        super(name);
        this.room = room;
    }

    public String getRoom(){
        return room;
    }
}
