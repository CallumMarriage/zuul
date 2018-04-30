package com.callum.model.Parsers;

import com.callum.model.items.Item;
import com.callum.model.items.ItemFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.callum.model.constants.GameConstants.ITEMS;

/**
 * Created by callummarriage on 27/04/2018.
 */
public class ItemParser {

    public static List<Item> readFile(){

        List<Item> items = new ArrayList<>();
        try {
            Object object = new JSONParser().parse(new FileReader(ITEMS));

            JSONArray jsonArray= (JSONArray) object;

            for(Object o : jsonArray) {
                JSONObject item = (JSONObject) o;
                items.add(ItemFactory.createItem((String) item.get("type"), (String) item.get("name"), (String) item.get("description"), (String) item.get("value")));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return items;
    }
}
