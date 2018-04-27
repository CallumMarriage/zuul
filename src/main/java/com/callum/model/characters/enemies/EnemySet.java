package com.callum.model.characters.enemies;

import com.callum.model.characters.Character;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class EnemySet {
    private ArrayList enemies;
    private SecureRandom random;

    public EnemySet(SecureRandom random){
        this.random = random;
        enemies = new ArrayList();
    }

    public Enemy findRandomEnemy(){
        if(enemies.size()==0){
            return null;
        }
        int i = random.nextInt(enemies.size());
        return (Enemy) enemies.get(i);
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
}
