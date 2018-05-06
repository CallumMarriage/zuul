package com.callum.model.commands.oneArgCommands;

import com.callum.model.Game;
import com.callum.model.characters.enemies.Enemy;

/**
 * Created by callummarriage on 24/04/2018.
 */
public class GoCommand extends OneArgCommand {


    public GoCommand(){

    }

    public String getSyntax() {
        return "go direction";
    }

    public boolean act(Game g){

        if(g.getCurrentRoom().getEnemy() == null || g.getCurrentRoom().getEnemy().getHealth() <=0){
            if(g.getCurrentRoom().getExit(arg)!= null){
                if(g.getCurrentRoom().getExit(arg).getLocked()){
                    if(!g.getCurrentPlayer().unlock(g.getCurrentRoom().getExit(arg))){
                        System.out.println("The room is locked, you have to find the key!");
                        return false;
                    }
                }
                g.setCurrentRoom(g.getCurrentRoom().getExit(arg));
                if(g.getCurrentRoom().getIsBossRoom()){
                    System.out.println(
                            " ▀█████████▄   ▄██████▄     ▄████████    ▄████████         ▄████████  ▄██████▄   ▄██████▄    ▄▄▄▄███▄▄▄▄   \n" +
                            "  ███    ███ ███    ███   ███    ███   ███    ███        ███    ███ ███    ███ ███    ███ ▄██▀▀▀███▀▀▀██▄ \n" +
                            "  ███    ███ ███    ███   ███    █▀    ███    █▀         ███    ███ ███    ███ ███    ███ ███   ███   ███ \n" +
                            " ▄███▄▄▄██▀  ███    ███   ███          ███              ▄███▄▄▄▄██▀ ███    ███ ███    ███ ███   ███   ███ \n" +
                            "▀▀███▀▀▀██▄  ███    ███ ▀███████████ ▀███████████      ▀▀███▀▀▀▀▀   ███    ███ ███    ███ ███   ███   ███ \n" +
                            "  ███    ██▄ ███    ███          ███          ███      ▀███████████ ███    ███ ███    ███ ███   ███   ███ \n" +
                            "  ███    ███ ███    ███    ▄█    ███    ▄█    ███        ███    ███ ███    ███ ███    ███ ███   ███   ███ \n" +
                            "▄█████████▀   ▀██████▀   ▄████████▀   ▄████████▀         ███    ███  ▀██████▀   ▀██████▀   ▀█   ███   █▀  \n" +
                            "                                                         ███    ███                                       ");
                }
                System.out.println(g.getCurrentRoom().getLongDescription());
                Enemy newEnemy = g.getCurrentRoom().getEnemy();

                if(newEnemy != null) {
                    if(!newEnemy.getDead()) {
                        System.out.println(newEnemy.getDescription());
                       return false;
                   } else{
                       System.out.println("The enemy lays slain");
                   }
               } else{
                    System.out.println("The room is empty, you may move on.");
                }
            } else{
                System.out.println("You cant go that way you idiot!!");
            }
        } else{
            System.out.println("The exits are blocked, you must defeat " + g.getCurrentRoom().getEnemy().getName() + " before moving on!!");
        }
        return false;
    }

}
