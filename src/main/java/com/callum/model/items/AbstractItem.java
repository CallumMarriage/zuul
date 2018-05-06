package com.callum.model.items;

import com.callum.model.characters.Character;


/**
 * Created by callummarriage on 26/04/2018.
 */
public abstract class AbstractItem implements Item{

    protected boolean isActive;
    protected String name;
    protected String description;

    public AbstractItem(String name, String description){
        this.description = description;
        this.isActive = true;
        this.name = name;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void setActive(boolean setInactive) {
        this.isActive = setInactive;
    }

    @Override
    public String getLongDescription(){
        StringBuilder sb = new StringBuilder();

        sb.append("\nThe room contains ");
        sb.append(description + ".");
        return sb.toString();
    }

    @Override
    public String getBasicInfo() {
        return name;
    }


    public abstract Integer act(Character character);

    @Override
    public String giveDescription() {
        return "\nYou have picked up the " + name + ".";
    }

    public String getName(){
        return name;
    }
}
