package com.callum.model.characters.enemies;

import com.callum.model.characters.Character;
import com.callum.model.items.Weapon;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class KnightEnemy extends Enemy {

    public KnightEnemy(Weapon weapon, String name, int health){
        super(name, weapon, health);
        type ="Knight";
    }

    @Override
    public boolean attack(Character opponent) {
        int damage = weapon.act(opponent);
        System.out.println("The enemy has attacked you doing " + damage + " damage");
        return true;
    }

    @Override
    public void speak(String command) {
        System.out.println("Hi, I am a knight");
    }

}
