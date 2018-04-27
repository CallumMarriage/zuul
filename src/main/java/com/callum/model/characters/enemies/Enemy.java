package com.callum.model.characters.enemies;

import com.callum.model.characters.AbstractCharacter;
import com.callum.model.characters.Character;
import com.callum.model.characters.weapons.Weapon;

/**
 * Created by callummarriage on 26/04/2018.
 */
public abstract class Enemy extends AbstractCharacter {


    public Enemy(String name, Weapon weapon, int health) {
        super(name, weapon, health);
    }

    @Override
    public abstract void attack(Character opponent);

    @Override
    public abstract void speak(String command);

    public void getDescription(){
        System.out.println("A figure approaches " + name + " towers over you!");
    }

}
