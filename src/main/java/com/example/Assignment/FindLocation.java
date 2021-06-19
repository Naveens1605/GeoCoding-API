package com.example.Assignment;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@Path("/find-location")
public class FindLocation {
    @POST
    @Produces("application/json")
    public ArrayList<Location> getAddress(String jsonBody) throws IOException {
        ArrayList<Location> arrayList = new ArrayList<>();
        JSONObject reader = new JSONObject(jsonBody);
        Iterator<String> iteratorObj = reader.keys();
        JSONObject jsonObject = new JSONObject(jsonBody);
        JSONArray add = jsonObject.optJSONArray(iteratorObj.next());
        SendAPIRequest sendAPIRequest = new SendAPIRequest();
        for(int i = 0 ; i < add.length() ; i++){
            arrayList.add(sendAPIRequest.sendAPIRequest(add.getString(i)));
        }
        return arrayList;
    }
}