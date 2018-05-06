package com.callum.model.characters.enemies.factory;


import com.callum.model.characters.enemies.BossEnemy;
import com.callum.model.characters.enemies.Enemy;
import com.callum.model.characters.enemies.KnightEnemy;
import com.callum.model.items.characterItems.weapons.Weapon;

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
