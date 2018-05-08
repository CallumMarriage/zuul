package com.callum.zuul.model.commands.noArgCommands;

import com.callum.zuul.Application;
import com.callum.zuul.model.items.Item;
import com.callum.zuul.model.items.characterItems.CharacterItem;
import com.callum.zuul.model.items.characterItems.armour.Armour;

/**
 * Created by callummarriage on 02/05/2018.
 */
public class ListItemsCommand extends NoArgCommand {
    public ListItemsCommand(){

    }

    public String getSyntax() {
        return "go direction";
    }

    public boolean act(Application g){

        System.out.println(createTitle("INVENTORY"));
        if(g.getCurrentPlayer().getItems().size() == 0){
            System.out.println("You have no items");
            return false;
        }
        for(Item item : g.getCurrentPlayer().getItems()){
            if(item instanceof CharacterItem){
                String isBroken = "";
                if(item instanceof Armour ) {
                    Armour armour = (Armour) item;
                    if(armour.getValue() <= 0){
                        isBroken = " (Broken)";
                    }
                }
                System.out.println(((CharacterItem) item).getCharacterItemsAndValues() + isBroken);
            } else {
                System.out.println(item.getName());
            }
        }
        return false;
    }

}
