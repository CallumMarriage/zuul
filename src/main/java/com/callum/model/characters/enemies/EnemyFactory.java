package com.callum.model.characters.enemies;


import com.callum.model.items.Weapon;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class EnemyFactory {

    public static Enemy createEnemy(String type, String name, String health, Weapon weapon){
        switch (type){
            case "KnightEnemy": return new KnightEnemy( weapon, name, Integer.parseInt(health));
            case "BossEnemy": return new BossEnemy(weapon, name, Integer.parseInt(health));
            default: return null;
        }
    }
}
