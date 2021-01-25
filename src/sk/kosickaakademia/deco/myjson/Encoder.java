package sk.kosickaakademia.deco.myjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Encoder {
    public static void main(String[] args) {
        JSONObject first=new JSONObject();
        JSONArray sport=new JSONArray();
        sport.add("futbal");
        sport.add("hockey");

        first.put("name","Jozef");
        first.put("age", 52);
        first.put("sport",sport);
        first.put("active",false);

        System.out.println(first);
    }
}
