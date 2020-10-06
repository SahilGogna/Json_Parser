import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AppStarter {
    public static void main(String[] args) throws IOException {
        String stationInformation = JsonParser.parseJsonURL("https://api-core.bixi.com/gbfs/en/station_information.json");
        String systemInformation = JsonParser.parseJsonURL("https://api-core.bixi.com/gbfs/en/system_information.json");
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        SystemInformationJson systemInformationJson = gson.fromJson(systemInformation, SystemInformationJson.class);
        StationInformationJson stationInformationJson = gson.fromJson(stationInformation, StationInformationJson.class);

        Map<String, EnrichedStationInformation> enrichedStationInformationMap = new HashMap<>();
        SystemInformationEntity systemInformationEntity = getSystemInf(systemInformationJson);

        for (StationInformationEntity object : stationInformationJson.getData().getStations()) {
            enrichedStationInformationMap
                    .put(object.getStation_id(),
                            new EnrichedStationInformation(object, systemInformationEntity));
        }
        FileWriter.writeToLocalFs(enrichedStationInformationMap);
    }

    private static SystemInformationEntity getSystemInf(SystemInformationJson systemInformationJson) {

        SystemInformationEntity systemInformationEntity = new SystemInformationEntity();
        systemInformationEntity.setEmail(systemInformationJson.getData().getEmail());
        systemInformationEntity.setSystem_id(systemInformationJson.getData().getSystem_id());
        systemInformationEntity.setLanguage(systemInformationJson.getData().getLanguage());
        systemInformationEntity.setShort_name(systemInformationJson.getData().getShort_name());
        systemInformationEntity.setName(systemInformationJson.getData().getName());
        systemInformationEntity.setOperator(systemInformationJson.getData().getOperator());
        systemInformationEntity.setUrl(systemInformationJson.getData().getUrl());
        systemInformationEntity.setStart_date(systemInformationJson.getData().getStart_date());
        systemInformationEntity.setPhone_number(systemInformationJson.getData().getPhone_number());
        systemInformationEntity.setLicense_url(systemInformationJson.getData().getLicense_url());
        systemInformationEntity.setTimezone(systemInformationJson.getData().getTimezone());

        return systemInformationEntity;
    }
}
