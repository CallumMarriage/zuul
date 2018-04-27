package com.callum.model.items;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class Health extends AbstractItem {

    private int value;

    public Health(String name, int value){
        super(name);
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
