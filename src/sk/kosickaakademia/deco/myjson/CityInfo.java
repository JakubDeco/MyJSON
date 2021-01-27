package sk.kosickaakademia.deco.myjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class CityInfo {
    public void parseCityInfo(String filepath) {
        JSONParser jsonParser=new JSONParser();
        try {
            FileReader fileReader=new FileReader(filepath);
            JSONObject root=(JSONObject) jsonParser.parse(fileReader);

            JSONArray data= (JSONArray) root.get("data");
            for (Object item : data) {
                JSONObject temp = (JSONObject) item;

                if (!(temp.get("type")).equals("CITY"))
                    break;

                System.out.println("name: " + temp.get("name"));
                System.out.println("region: " + temp.get("region"));
                System.out.println("wikiDataId: " + temp.get("wikiDataId"));
                System.out.println("latitude: " + temp.get("latitude"));
                System.out.println("longitude: " + temp.get("longitude"));
                System.out.println();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
