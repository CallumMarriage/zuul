package com.callum.model.characters.enemies;

import com.callum.model.characters.Character;
import com.callum.model.characters.weapons.Weapon;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class BossEnemy extends Enemy {

    public BossEnemy(Weapon weapon, String name, int health){
        super(name, weapon, health);
    }

    @Override
    public void attack(Character opponent) {
        int damage = weapon.dealDamage(opponent);
        System.out.println("The enemy has attacked you doing " + damage + " damage");
    }

    @Override
    public void speak(String command) {
        System.out.println("Hi my name is, my name is");
    }

}
