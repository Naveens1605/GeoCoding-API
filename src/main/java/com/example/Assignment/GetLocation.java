package com.example.Assignment;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetLocation {

    public Location getLocation(String s, String name){
        JSONObject json = new JSONObject(s);
        JSONArray results = json.getJSONArray("results");
        JSONObject getJSON = results.getJSONObject(0);
        JSONObject geometryArray = getJSON.getJSONObject("geometry");
        JSONObject internetLocation = geometryArray.getJSONObject("location");
        Location location = new Location();
        location.setAdd(name);
        double[] array = {internetLocation.getDouble("lat"),internetLocation.getDouble("lng")};
        location.setLocation(array);
        return location;
    }
}
