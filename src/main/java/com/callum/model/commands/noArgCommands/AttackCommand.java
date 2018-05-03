package com.callum.model.commands.noArgCommands;

import com.callum.model.Game;
import com.callum.model.characters.enemies.Enemy;
import com.callum.model.characters.player.Player;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class AttackCommand extends NoArgCommand {

    /**
     * @param g
     * @return
     */
    @Override
    public boolean act(Game g) {
        Enemy currentEnemy = g.getCurrentRoom().getEnemy();
        Player player = g.getCurrentPlayer();
        player.attack(g.getCurrentRoom().getEnemy());

        if(currentEnemy != null) {
            if (currentEnemy.getHealth() > 0) {
                currentEnemy.attack(player);
                if (player.getHealth() <= 0) {
                    System.out.println("You have been defeated!!!");
                    return true;
                }
            } else {
                currentEnemy.kill();
                g.getCurrentPlayer().updateScore(currentEnemy.getValue());
                if (currentEnemy.getType().equals("Boss")) {
                    System.out.println("You have defeated " + currentEnemy.getName() + ", the world bows to your glory. \n YOU WIN!!");
                    return true;
                }
                System.out.println(currentEnemy.getName() + " lies defeated, you may move on.");
            }
        } else {
            System.out.println("There is no one to attack.");
        }
        return false;
    }
}
