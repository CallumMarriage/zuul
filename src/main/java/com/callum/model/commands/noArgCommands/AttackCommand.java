package com.callum.model.commands.noArgCommands;

import com.callum.model.Game;
import com.callum.model.characters.enemies.Enemy;
import com.callum.model.characters.player.Player;

import static com.callum.model.constants.GameConstants.ENEMIES2;
import static com.callum.model.constants.GameConstants.ITEMS2;
import static com.callum.model.constants.GameConstants.ROOMS2;

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
                    if(g.getLevel() < g.numberOfLevls){
                        g.setLevel(g.getLevel()+1);
                        try {
                            g.loadLevel();
                            return false;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
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
