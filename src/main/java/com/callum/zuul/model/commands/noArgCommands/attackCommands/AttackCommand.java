package com.callum.zuul.model.commands.noArgCommands.attackCommands;

import com.callum.zuul.Application;
import com.callum.zuul.model.characters.enemies.Enemy;
import com.callum.zuul.model.characters.player.Player;
import com.callum.zuul.model.commands.noArgCommands.NoArgCommand;
import com.callum.zuul.model.items.characterItems.weapons.Arrow;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import static com.callum.zuul.model.constants.BigWords.GAME_OVER;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class AttackCommand extends NoArgCommand {


    public boolean attack(Application g, String type) {
        Random random = new SecureRandom();

        Enemy currentEnemy = g.getCurrentRoom().getEnemy();
        Player player = g.getCurrentPlayer();
        if(type.equals("sword")) {
            player.attack(g.getCurrentRoom().getEnemy());
        } else {
            if (player.getBow() != null) {
                if(g.getCurrentPlayer().getArrows().size() > 0) {
                    player.getBow().fire(g.getCurrentPlayer().getArrows(), currentEnemy);
                    List<Arrow> arrows = player.getArrows();
                    if(random.nextBoolean()) {
                        g.getCurrentRoom().setItem(arrows.get(0));
                    }
                    arrows.remove(0);
                    player.setArrows(arrows);
                } else {
                    System.out.println("You do not have any arrows");
                }
            } else {
                System.out.println("You do not have a bow!");
            }
        }

        if(currentEnemy != null) {
            if (currentEnemy.getHealth() > 0) {
                if(type.equals("sword")) {
                    currentEnemy.attack(player);
                } else {
                    if (currentEnemy.getBow() != null) {
                        currentEnemy.getBow().fire(currentEnemy.getArrows(), player);

                    }
                }
                if (player.getHealth() <= 0) {
                    System.out.println("You have been defeated!!!");
                    System.out.println(GAME_OVER);
                    return true;
                }
            } else {
                currentEnemy.kill();
                g.getCurrentPlayer().updateScore(currentEnemy.getValue());
                if (currentEnemy.getType().equals("Boss")) {
                    System.out.println("You have defeated " + currentEnemy.getName());
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
