package com.callum.model.characters.enemies;

import com.callum.model.characters.AbstractCharacter;
import com.callum.model.characters.Character;
import com.callum.model.items.characterItems.weapons.Weapon;

/**
 * Created by callummarriage on 26/04/2018.
 */
public abstract class Enemy extends AbstractCharacter {

    protected String type;
    int value;

    public Enemy(String name, Weapon weapon, int health) {
        super(name, weapon, health);
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public abstract boolean attack(Character opponent);

    @Override
    public abstract void speak(String command);

    public void printDescription(){
        System.out.println("A figure approaches, " + name + " towers over you!");
    }

    public String getDescription(){
        return "\nThere is an enemy present, you will have to defeat them before moving on!" + "\nA figure approaches, " + name + " towers over you!";
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
