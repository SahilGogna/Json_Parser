import com.opencsv.CSVWriter;
import org.apache.hadoop.fs.FileSystem;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.hadoop.fs.Path;

public class FileWriter {

    static String localFilePath = "/Users/sahilgogna/Documents/Big Data College/sprint2OP.csv";

    private static void writeToHdfs() throws IOException {
        String outputFolderPath = "/user/fall2019/sahilgogna/sprint2";

        FileSystem fileSystem = HdfsWriter.getHdfs();

        boolean contains = fileSystem.exists(new Path(outputFolderPath));
        if (contains) {
            fileSystem.delete(new Path(outputFolderPath), true);
        }
        fileSystem.mkdirs(new Path(outputFolderPath));
        fileSystem.copyFromLocalFile(new Path(localFilePath), new Path(outputFolderPath));
    }

    public static void writeToLocalFs(Map<String, EnrichedStationInformation> map) throws IOException {
        File file = new File(localFilePath);
        java.io.FileWriter fileWriter = new java.io.FileWriter(file);
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
                "system_id",
                "language",
                "name",
                "short_name",
                "operator",
                "url",
                "start_date",
                "phone_number",
                "email",
                "license_url",
                "timezone"
        };

        writer.writeNext(csvSchema);
        for (String key : map.keySet()) {
            EnrichedStationInformation entry = map.get(key);
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
                    String.valueOf(entry.getSystemInformationEntity().getSystem_id()),
                    String.valueOf(entry.getSystemInformationEntity().getLanguage()),
                    String.valueOf(entry.getSystemInformationEntity().getName()),
                    String.valueOf(entry.getSystemInformationEntity().getShort_name()),
                    String.valueOf(entry.getSystemInformationEntity().getOperator()),
                    String.valueOf(entry.getSystemInformationEntity().getUrl()),
                    String.valueOf(entry.getSystemInformationEntity().getStart_date()),
                    String.valueOf(entry.getSystemInformationEntity().getPhone_number()),
                    String.valueOf(entry.getSystemInformationEntity().getEmail()),
                    String.valueOf(entry.getSystemInformationEntity().getLicense_url()),
                    String.valueOf(entry.getSystemInformationEntity().getTimezone())
            };
            writer.writeNext(data);
        }
        writer.close();
        writeToHdfs();
    }
}
