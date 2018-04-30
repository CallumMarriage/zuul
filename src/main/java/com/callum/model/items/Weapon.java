package com.callum.model.items;

import com.callum.model.characters.Character;

import java.security.SecureRandom;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class Weapon extends AbstractItem {

    private int maxDamage;

    public Weapon(String name, String description, int maxDamage){
        super(name, description);
        this.maxDamage = maxDamage;
    }

    public Integer getDamage(){
        return maxDamage;
    }

    @Override
    public Integer act(Character character) {
        SecureRandom rand = new SecureRandom();
        int i = rand.nextInt(maxDamage) + 1;
        character.setHealth(character.getHealth() - i);
        return i;
    }

}
