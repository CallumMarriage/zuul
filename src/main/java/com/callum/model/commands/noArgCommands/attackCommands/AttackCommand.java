package com.callum.model.commands.noArgCommands.attackCommands;

import com.callum.Game;
import com.callum.model.characters.enemies.Enemy;
import com.callum.model.characters.player.Player;
import com.callum.model.commands.noArgCommands.NoArgCommand;
import com.callum.model.items.characterItems.weapons.Arrow;

import java.util.List;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class AttackCommand extends NoArgCommand {

    public boolean attack(Game g, String type) {
        Enemy currentEnemy = g.getCurrentRoom().getEnemy();
        Player player = g.getCurrentPlayer();
        if(type.equals("sword")) {
            player.attack(g.getCurrentRoom().getEnemy());
        } else {
            if (player.getBow() != null) {
                if(g.getCurrentPlayer().getArrows().size() > 0) {
                    player.getBow().fire(g.getCurrentPlayer().getArrows(), currentEnemy);
                    List<Arrow> arrows = player.getArrows();
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
                    System.out.println(
                            "\n" +
                            "   ▄██████▄     ▄████████   ▄▄▄▄███▄▄▄▄      ▄████████       ▄██████▄   ▄█    █▄     ▄████████    ▄████████ \n" +
                            "  ███    ███   ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███      ███    ███ ███    ███   ███    ███   ███    ███ \n" +
                            "  ███    █▀    ███    ███ ███   ███   ███   ███    █▀       ███    ███ ███    ███   ███    █▀    ███    ███ \n" +
                            " ▄███          ███    ███ ███   ███   ███  ▄███▄▄▄          ███    ███ ███    ███  ▄███▄▄▄      ▄███▄▄▄▄██▀ \n" +
                            "▀▀███ ████▄  ▀███████████ ███   ███   ███ ▀▀███▀▀▀          ███    ███ ███    ███ ▀▀███▀▀▀     ▀▀███▀▀▀▀▀   \n" +
                            "  ███    ███   ███    ███ ███   ███   ███   ███    █▄       ███    ███ ███    ███   ███    █▄  ▀███████████ \n" +
                            "  ███    ███   ███    ███ ███   ███   ███   ███    ███      ███    ███ ███    ███   ███    ███   ███    ███ \n" +
                            "  ████████▀    ███    █▀   ▀█   ███   █▀    ██████████       ▀██████▀   ▀██████▀    ██████████   ███    ███ \n" +
                            "                                                                                                 ███    ███ ");
                    return true;
                }
            } else {
                currentEnemy.kill();
                g.getCurrentPlayer().updateScore(currentEnemy.getValue());
                if (currentEnemy.getType().equals("Boss")) {
                    System.out.println("You have defeated " + currentEnemy.getName() + "\n"+
                            "▄█          ▄████████  ▄█    █▄     ▄████████  ▄█             ▄████████  ▄██████▄    ▄▄▄▄███▄▄▄▄      ▄███████▄  ▄█          ▄████████     ███        ▄████████ ████████▄  \n" +
                            "███         ███    ███ ███    ███   ███    ███ ███            ███    ███ ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███ ███         ███    ███ ▀█████████▄   ███    ███ ███   ▀███ \n" +
                            "███         ███    █▀  ███    ███   ███    █▀  ███            ███    █▀  ███    ███ ███   ███   ███   ███    ███ ███         ███    █▀     ▀███▀▀██   ███    █▀  ███    ███ \n" +
                            "███        ▄███▄▄▄     ███    ███  ▄███▄▄▄     ███            ███        ███    ███ ███   ███   ███   ███    ███ ███        ▄███▄▄▄         ███   ▀  ▄███▄▄▄     ███    ███ \n" +
                            "███       ▀▀███▀▀▀     ███    ███ ▀▀███▀▀▀     ███            ███        ███    ███ ███   ███   ███ ▀█████████▀  ███       ▀▀███▀▀▀         ███     ▀▀███▀▀▀     ███    ███ \n" +
                            "███         ███    █▄  ███    ███   ███    █▄  ███            ███    █▄  ███    ███ ███   ███   ███   ███        ███         ███    █▄      ███       ███    █▄  ███    ███ \n" +
                            "███▌    ▄   ███    ███ ███    ███   ███    ███ ███▌    ▄      ███    ███ ███    ███ ███   ███   ███   ███        ███▌    ▄   ███    ███     ███       ███    ███ ███   ▄███ \n" +
                            "█████▄▄██   ██████████  ▀██████▀    ██████████ █████▄▄██      ████████▀   ▀██████▀   ▀█   ███   █▀   ▄████▀      █████▄▄██   ██████████    ▄████▀     ██████████ ████████▀  \n" +
                            "▀                                              ▀                                                                 ▀                                                          ");
                    if(g.getLevel() < g.numberOfLevls){
                        g.setLevel(g.getLevel()+1);
                        try {
                            g.loadLevel();
                            return false;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("\n\n\n\n" +
                            "    _       _     __   __            _    _ _____ _   _ _ _ _      _       _    \n" +
                            " /\\| |/\\ /\\| |/\\  \\ \\ / /           | |  | |_   _| \\ | | | | |  /\\| |/\\ /\\| |/\\ \n" +
                            " \\ ` ' / \\ ` ' /   \\ V /___  _   _  | |  | | | | |  \\| | | | |  \\ ` ' / \\ ` ' / \n" +
                            "|_     _|_     _|   \\ // _ \\| | | | | |/\\| | | | | . ` | | | | |_     _|_     _|\n" +
                            " / , . \\ / , . \\    | | (_) | |_| | \\  /\\  /_| |_| |\\  |_|_|_|  / , . \\ / , . \\ \n" +
                            " \\/|_|\\/ \\/|_|\\/    \\_/\\___/ \\__,_|  \\/  \\/ \\___/\\_| \\_(_|_|_)  \\/|_|\\/ \\/|_|\\/ \n" +
                            "                                                                                \n" +
                            "                                                                                ");
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
