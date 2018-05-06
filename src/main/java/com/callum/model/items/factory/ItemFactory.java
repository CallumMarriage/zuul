package com.callum.model.items.factory;

import com.callum.model.items.Health;
import com.callum.model.items.Item;
import com.callum.model.items.Key;
import com.callum.model.items.characterItems.armour.Chestplate;
import com.callum.model.items.characterItems.armour.Helmet;
import com.callum.model.items.characterItems.armour.Shield;
import com.callum.model.items.characterItems.weapons.Bow;
import com.callum.model.items.characterItems.weapons.Staff;
import com.callum.model.items.characterItems.weapons.Sword;

/**
 * Created by callummarriage on 27/04/2018.
 */
public class ItemFactory {

    public static Item createItem(String item, String name, String description, String value){
        switch (item){
            case "health": return new Health(name, description, Integer.parseInt(value));
            case "key": return new Key(name, description, value);
            case "bow": return new Bow(name, description, Integer.parseInt(value));
            case "sword" :  return new Sword(name, description, Integer.parseInt(value));
            case "staff" :  return new Staff(name, description, Integer.parseInt(value));
            case "helmet" : return new Helmet(name, description, Integer.parseInt(value));
            case "shield" : return new Shield(name, description, Integer.parseInt(value));
            case "chestplate": return new Chestplate(name, description, Integer.parseInt(value));
            default: return null;
        }
    }
}
