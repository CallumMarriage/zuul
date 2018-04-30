package com.callum.model.commands;

import com.callum.model.Game;
import com.callum.model.characters.enemies.Enemy;
import com.callum.model.rooms.Room;

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
            if(g.getCurrentRoom().getExit(direction)!= null){
                if(g.getCurrentRoom().getExit(direction).getLocked()){
                    if(!g.getCurrentPlayer().unlock(g.getCurrentRoom().getExit(direction))){
                        System.out.println("The room is locked, you have to find the key!");
                        return false;
                    }
                }
                g.setCurrentRoom(g.getCurrentRoom().getExit(direction));
                System.out.println(g.getCurrentRoom().getLongDescription());
                Enemy newEnemy = g.getCurrentRoom().getEnemy();

                if(newEnemy != null) {
                    if(!newEnemy.getDead()) {
                       newEnemy.getDescription();
                       return false;
                   } else{
                       System.out.println("The enemy lays slain");
                   }
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
