import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppStarter {
    public static void main(String[] args) throws IOException {

        String stationInformation = JsonParser.parseJsonURL("https://api-core.bixi.com/gbfs/en/station_information.json");
        String stationStatus = JsonParser.parseJsonURL("https://api-core.bixi.com/gbfs/en/station_status.json");

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        StationInformationJson stationInformationJson = gson.fromJson(stationInformation,  StationInformationJson.class);
        StationStatusJson stationStatusJson = gson.fromJson(stationStatus, StationStatusJson.class);

        Map<String, StationInformationEntity> stationInformationMap = new HashMap<>();
        Map<String, StationStatusEntity> stationStatusMap = new HashMap<>();
        Map<String, EnrichedStationEntity> enrichedStationMap = new HashMap<>();

        for(StationInformationEntity object: stationInformationJson.getData().getStations()){
            stationInformationMap.put(object.getStation_id(), object);
        }

        for(StationStatusEntity object: stationStatusJson.getData().getStations()){
            stationStatusMap.put(object.getStation_id(), object);
        }

        for(String key: stationInformationMap.keySet()){
            enrichedStationMap
                    .put(key,
                            new EnrichedStationEntity(stationInformationMap.get(key),stationStatusMap.get(key)));
        }

        Writer.writeToLocalFs(enrichedStationMap);
    }
}
