package com.callum.model.characters.enemies;

import com.callum.model.characters.Character;
import com.callum.model.items.Weapon;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class BossEnemy extends Enemy {

    public BossEnemy(Weapon weapon, String name, int health){
        super(name, weapon, health);
        type = "Boss";
    }

    @Override
    public boolean attack(Character opponent) {
        if(opponent != null) {
            int damage = weapon.act(opponent);
            System.out.println("The enemy has attacked you doing " + damage + " damage");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void speak(String command) {
        System.out.println("Hi my name is, my name is");
    }

}
