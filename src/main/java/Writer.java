import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Writer {
    public static void writeToLocalFs(Map<String, EnrichedStationEntity> map) throws IOException {
        String outputPath = "/Users/sahilgogna/Documents/Big Data College/enrichedOutput.csv";
        File file = new File(outputPath);
        FileWriter fileWriter = new FileWriter(file);
        CSVWriter writer = new CSVWriter(fileWriter);

        String[] csvSchema = {
                "station_id",
                "external_id",
                "name",
                "short_name",
                "lat",
                "lon",
                "rental_methods",
                "capacity",
                "electric_bike_surcharge_waiver",
                "is_charging",
                "eightd_has_key_dispenser",
                "has_kiosk",
                "num_bikes_available",
                "num_ebikes_available",
                "num_bikes_disabled",
                "num_docks_available",
                "num_docks_disabled",
                "is_installed",
                "is_renting",
                "is_returning",
                "last_reported",
                "eightd_has_available_keys"
        };

        writer.writeNext(csvSchema);

        for (String key : map.keySet()) {
            EnrichedStationEntity entry = map.get(key);
            String[] data = {
                    entry.getStationInformationEntity().getStation_id(),
                    entry.getStationInformationEntity().getExternal_id(),
                    entry.getStationInformationEntity().getName(),
                    entry.getStationInformationEntity().getShort_name(),
                    String.valueOf(entry.getStationInformationEntity().getLat()),
                    String.valueOf(entry.getStationInformationEntity().getLon()),
                    entry.getStationInformationEntity().getRental_methods().toString(),
                    String.valueOf(entry.getStationInformationEntity().getCapacity()),
                    String.valueOf(entry.getStationInformationEntity().isElectric_bike_surcharge_waiver()),
                    String.valueOf(entry.getStationInformationEntity().isIs_charging()),
                    String.valueOf(entry.getStationInformationEntity().isEightd_has_key_dispenser()),
                    String.valueOf(entry.getStationInformationEntity().isHas_kiosk()),
                    String.valueOf(entry.getStationStatusEntity().getNum_bikes_available()),
                    String.valueOf(entry.getStationStatusEntity().getNum_ebikes_available()),
                    String.valueOf(entry.getStationStatusEntity().getNum_bikes_disabled()),
                    String.valueOf(entry.getStationStatusEntity().getNum_docks_available()),
                    String.valueOf(entry.getStationStatusEntity().getNum_docks_disabled()),
                    String.valueOf(entry.getStationStatusEntity().getIs_installed()),
                    String.valueOf(entry.getStationStatusEntity().getIs_renting()),
                    String.valueOf(entry.getStationStatusEntity().getIs_returning()),
                    String.valueOf(entry.getStationStatusEntity().getLast_reported()),
                    String.valueOf(entry.getStationStatusEntity().isEightd_has_available_keys()),
            };
            writer.writeNext(data);
        }
        writer.close();

    }
}
