package com.example.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendAPIRequest {

    Location location;

    public Location sendAPIRequest(String json) throws IOException {
        String address = json.replaceAll(" ", "");
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=";
        String api = ",&key=AIzaSyA5bwbEsAOUMOI4RK2zXcIayG4vjuQSpcw";
        URL obj = new URL(url +""+address+"" + api);
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            in.close();
            GetLocation getLocation = new GetLocation();
            location = getLocation.getLocation(stringBuilder.toString(),json);
        } else {
            System.out.println("GET request not worked");
        }
        return location;
    }
}
