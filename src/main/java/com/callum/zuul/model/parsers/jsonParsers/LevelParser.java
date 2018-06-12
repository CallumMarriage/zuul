package com.callum.zuul.model.parsers.jsonParsers;

import com.callum.zuul.model.containers.Container;
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
public class LevelParser {
    public static List<Container> readFile(String enemiesFile){

        List<Container> levels = new ArrayList<>();
        try {
            Object object = new JSONParser().parse(new FileReader(enemiesFile));

            JSONArray jsonArray= (JSONArray) object;

            for(Object o : jsonArray) {
                JSONObject item = (JSONObject) o;
                String name = (String) item.get("name");
                Integer number = Integer.parseInt((String) item.get("number"));
                String description = (String) item.get("description");

                levels.add(new Container(name, description, number));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return levels;
    }
}
