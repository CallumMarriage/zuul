package com.callum.model.items;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class AbstractItem implements Item{

    protected boolean isActive;
    protected String name;

    public AbstractItem(String name){
        isActive = false;
        this.name = name;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void setInactive(boolean setInactive) {
        this.isActive = setInactive;
    }

    @Override
    public String giveDescription() {
        return "This is a " + name + ".";
    }

    public String getName(){
        return name;
    }
}
