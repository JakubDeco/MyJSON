package sk.kosickaakademia.deco.myjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.Iterator;


public class JSONExcercise {
    public static void main(String[] args) {
        encodeJSON();
        parseFirstJSON("resource/test.json");
        weatherKosiceSK("resource/weather.json");
    }

    private static void encodeJSON() {
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

    public  static void parseFirstJSON(String filepath){
        JSONParser parser=new JSONParser();
        try{
            FileReader fileReader=new FileReader(filepath);
            JSONObject jsonObject=(JSONObject) parser.parse(fileReader);

            //print whole json
            System.out.println(jsonObject);

            //print name
            String name= (String) jsonObject.get("name");
            System.out.println(name);
            //print age
            long age= (long) jsonObject.get("age");
            System.out.println(age);
            //print messages
            JSONArray messages=(JSONArray) jsonObject.get("messages");
            Iterator iterator=messages.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
            /*for (Object message : messages)
                System.out.println(message);*/
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }

    public static void weatherKosiceSK(String filepath){
        JSONParser jsonParser=new JSONParser();
        try{
            FileReader fileReader=new FileReader(filepath);
            JSONObject jsonObject=(JSONObject) jsonParser.parse(fileReader);
            JSONObject main=(JSONObject)jsonObject.get("main");

            //teplota v C
            System.out.println(Math.round(((Double) main.get("temp")-273.15)*100)/100);

            //tlak v hPa
            System.out.println((long)main.get("pressure")/100+"hPa");

            //viditelnost v metroch
            System.out.println(jsonObject.get("visibility")+"m");

            //vlhkost v percentach,
            System.out.println(main.get("humidity")+"%");

            //vychod a zapad slnka v tvare HH:mm
            JSONObject sys=(JSONObject)jsonObject.get("sys");
            Time sunrise=new Time((Long) sys.get("sunrise")*1000);
            Time sunset=new Time((Long) sys.get("sunset")*1000);
            System.out.println("sunrise: "+sunrise.toString());
            System.out.println("sunset: "+sunset.toString());


        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }
}
