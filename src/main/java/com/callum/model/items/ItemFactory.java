package com.callum.model.items;

/**
 * Created by callummarriage on 27/04/2018.
 */
public class ItemFactory {

    public static Item createItem(String item, String name, String description,  String value){
        switch (item){
            case "health": return new Health(name, description, Integer.parseInt(value));
            case "key": return new Key(name, description, value);
            case "weapon": return new Weapon(name, description, Integer.parseInt(value));
            default: return null;
        }
    }
}
