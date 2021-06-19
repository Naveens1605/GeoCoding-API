package com.example.Assignment;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.ArrayList;

@Path("/find-location")
public class HelloResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Location> getAddress(String jsonBody) throws IOException {
        ArrayList<Location> arrayList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonBody);
        JSONArray add = jsonObject.getJSONArray("add");
        SendAPIRequest sendAPIRequest = new SendAPIRequest();
        for(int i = 0 ; i < add.length() ; i++){
            arrayList.add(sendAPIRequest.sendAPIRequest(add.getString(i)));
        }
        return arrayList;
    }
}