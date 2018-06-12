package com.callum.zuul.model.parsers.jsonParsers;

import com.callum.zuul.model.characters.enemies.factory.EnemyFactory;
import com.callum.zuul.model.characters.enemies.EnemySet;
import com.callum.zuul.model.items.factory.ItemFactory;
import com.callum.zuul.model.items.characterItems.weapons.Weapon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by callummarriage on 29/04/2018.
 */
public class EnemyParser {

    public static EnemySet readFile(String enemiesFile){

        EnemySet enemies = new EnemySet();

        try {
            Object object = new JSONParser().parse(new FileReader(enemiesFile));

            JSONArray jsonArray= (JSONArray) object;

            for(Object o : jsonArray) {
                JSONObject item = (JSONObject) o;
                JSONObject JSONWeapon = (JSONObject) item.get("weapon");
                Weapon weapon = (Weapon) ItemFactory.createItem((String) JSONWeapon.get("type"),(String) JSONWeapon.get("name"),(String) JSONWeapon.get("description"), (String) JSONWeapon.get("value"));
                enemies.addEnemy(EnemyFactory.createEnemy((String) item.get("type"), (String) item.get("name"), (String) item.get("health"), weapon));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return enemies;
    }
}
