package com.callum.zuul.model.characters.enemies.factory;


import com.callum.zuul.model.characters.enemies.BossEnemy;
import com.callum.zuul.model.characters.enemies.Enemy;
import com.callum.zuul.model.characters.enemies.KnightEnemy;
import com.callum.zuul.model.items.characterItems.weapons.Weapon;

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
