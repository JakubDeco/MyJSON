package sk.kosickaakademia.deco.myjson;

public class Main {
    public static void main(String[] args) {
        CityInfo cityInfo=new CityInfo();
        cityInfo.parseCityInfo("resource/areaInfo.json");
    }
}
