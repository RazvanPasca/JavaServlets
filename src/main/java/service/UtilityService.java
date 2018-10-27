package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.CityEntity;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@AllArgsConstructor
public class UtilityService {

    FlightsService flightsService;
    private String url;

    public LocalDateTime getArrivalTime(int id) throws IOException {
        CityEntity arrivalCity = flightsService.getFlightById(id).getArrivalCity();
        long arrivalTimestamp = Timestamp.valueOf(flightsService.getFlightById(id).getArrivalTime()).getTime() / 1000;

        url = String
                .format(url, arrivalCity.getLattitude(), arrivalCity.getLongitude(), arrivalTimestamp);
        URL url = new URL(this.url);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);
        in.close();

        String jsonString = content.toString();
        System.out.println(jsonString);


        Map<String, String> jsonDict = new Gson().fromJson(jsonString, new TypeToken<HashMap<String, String>>() {
        }.getType());

        long dstOffset = Long.parseLong(jsonDict.get("dstOffset"));
        long rawOffset = Long.parseLong(jsonDict.get("rawOffset"));

        long finalTimestamp = arrivalTimestamp + dstOffset + rawOffset;
        LocalDateTime finalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(finalTimestamp*1000),
                TimeZone.getDefault().toZoneId());
        return finalDateTime;
    }
}


