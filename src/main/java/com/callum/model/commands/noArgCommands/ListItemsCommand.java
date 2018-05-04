package com.callum.model.commands.noArgCommands;

import com.callum.model.Game;
import com.callum.model.items.Item;
import com.callum.model.items.characterItems.CharacterItem;
import com.callum.model.items.characterItems.armour.Armour;
import com.callum.model.items.characterItems.weapons.Weapon;

/**
 * Created by callummarriage on 02/05/2018.
 */
public class ListItemsCommand extends NoArgCommand {
    public ListItemsCommand(){

    }

    public String getSyntax() {
        return "go direction";
    }

    public boolean act(Game g){

        if(g.getCurrentPlayer().getItems().size() == 0){
            System.out.println("You have no items");
            return false;
        }
        for(Item item : g.getCurrentPlayer().getItems()){
            if(item instanceof CharacterItem){
                System.out.println(((CharacterItem) item).getCharacterItemsAndValues());
            } else {
                System.out.println(item.getName());
            }
        }
        return false;
    }

}
