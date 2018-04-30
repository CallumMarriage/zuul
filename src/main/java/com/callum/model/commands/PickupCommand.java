package com.callum.model.commands;

import com.callum.model.Game;
import com.callum.model.characters.player.Player;
import com.callum.model.items.Item;

import java.util.List;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class PickupCommand extends NoArgCommand{
    @Override
    public String getSyntax() {
        return "pickup";
    }

    @Override
    public boolean act(Game g){
        if(g.getCurrentRoom().getEnemy() == null || g.getCurrentRoom().getEnemy().getDead())  {
                Player p = g.getCurrentPlayer();
                List<Item> items = g.getCurrentRoom().getItems();
                if(items == null){
                    System.out.println("There is nothing to pickup");
                } else {
                    for(Item item : items){
                        p.pickUp(item);
                        item.setActive(false);
                    }
                }
            } else{
                System.out.println("The enemy blocks the item");
        }
        return false;
    }
}
