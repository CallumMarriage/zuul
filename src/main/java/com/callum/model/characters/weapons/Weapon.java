package com.callum.model.characters.weapons;

import com.callum.model.characters.Character;

import java.security.SecureRandom;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class Weapon {

    private String name;
    private int maxDamage;

    public Weapon(String name, int maxDamage){
        this.name = name;
        this.maxDamage = maxDamage;
    }

    public Integer dealDamage(Character character){
        SecureRandom rand = new SecureRandom();
        int i = rand.nextInt(maxDamage) + 1;
        character.setHealth(character.getHealth() - i);
        return i;
    }

    public String getName(){
        return this.name;
    }

    public Integer getDamage(){
        return maxDamage;
    }
}
