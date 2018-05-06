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
