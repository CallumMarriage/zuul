package com.callum.model.characters.enemies;


import com.callum.model.characters.weapons.Weapon;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class EnemyFactory {

    public static Enemy createEnemy(String[] lineSplit){
        switch (lineSplit[0]){
            case "KnightEnemy": return new KnightEnemy(new Weapon(lineSplit[1], Integer.parseInt(lineSplit[4])) , lineSplit[2], Integer.parseInt(lineSplit[3]));
            default: return null;
        }
    }
}
