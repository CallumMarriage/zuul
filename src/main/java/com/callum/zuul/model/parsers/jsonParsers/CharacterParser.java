package com.callum.zuul.model.parsers.jsonParsers;

import com.callum.zuul.model.characters.Character;
import com.callum.zuul.model.characters.player.Player;
import com.callum.zuul.model.items.characterItems.weapons.Bow;
import com.callum.zuul.model.items.characterItems.weapons.Weapon;
import com.callum.zuul.model.items.factory.ItemFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by callummarriage on 12/06/2018.
 */
public class CharacterParser {

    public static List<Character> readFile(String enemiesFile){

        List<Character> characters = new ArrayList<>();

        try {
            Object object = new JSONParser().parse(new FileReader(enemiesFile));

            JSONArray jsonArray= (JSONArray) object;

            for(Object o : jsonArray) {
                JSONObject item = (JSONObject) o;
                String name = (String) item.get("name");
                Integer health = Integer.parseInt((String) item.get("health"));

                JSONObject JSONWeapon = (JSONObject) item.get("weapon");
                Weapon weapon = (Weapon) ItemFactory.createItem((String) JSONWeapon.get("type"),(String) JSONWeapon.get("name"),(String) JSONWeapon.get("description"), (String) JSONWeapon.get("value"));
                Player player = null;
                if(item.get("bow") != null){
                    JSONObject JSONBow = (JSONObject) item.get("bow");
                    Bow bow = new Bow((String) JSONBow.get("name"), (String) JSONBow.get("description"), (Integer) Integer.parseInt((String) JSONBow.get("value")));
                    Integer numOfArrows = Integer.parseInt((String) JSONBow.get("numOfArrows"));
                    player = new Player(weapon, name, bow, health, numOfArrows);
                } else {
                    player = new Player(weapon, name, health);
                }
                characters.add(player);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
