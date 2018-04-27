package com.callum.model.commands;

import com.callum.model.Game;
import com.callum.model.characters.Character;
import com.callum.model.characters.player.Player;

import java.util.Random;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class AttackCommand extends NoArgCommand {

    private Random random;
    private int playerAttack;

    public AttackCommand(){
        random = new Random(30);
        this.playerAttack = 50;
    }

    /**
     * @param g
     * @return
     */
    @Override
    public boolean act(Game g) {
        Character currentEnemy = g.getCurrentRoom().getEnemy();
        Player player = g.getCurrentPlayer();
        player.attack(g.getCurrentRoom().getEnemy());

        if(currentEnemy.getHealth() > 0){
            currentEnemy.attack(player);
            if(player.getHealth() <= 0 ){
                System.out.println("You have been defeated!!!");
                return true;
            }
        } else{
            currentEnemy.kill();
            System.out.println(currentEnemy.getName() + " lies defeated, you may move on.");
        }

        return false;
    }
}
