package com.callum.zuul.model.characters.enemies;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class EnemySet {
    private List<Enemy> enemies;

    public EnemySet(){
        enemies = new ArrayList<Enemy>();
    }

    public Enemy findRandomEnemy(){
        SecureRandom random = new SecureRandom();
        if(enemies.size()==0){
            return null;
        }
        int i = random.nextInt(enemies.size());
        return enemies.get(i);
    }

    public List<Enemy> getEnemies(){
        return enemies;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
}
