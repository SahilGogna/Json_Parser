import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveJdbcClient {
    private static final String STRICT_MODE_QUERY = "SET hive.exec.dynamic.partition.mode=nonstrict";
    private static final String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static final String connectionUrl = "jdbc:hive2://quickstart.cloudera:10000/sahlgogna;user=sahilgogna;password=sahilgogna";
    private static final String createQuery = new String("CREATE EXTERNAL TABLE fall2019_sahilgogna.external_station_information(station_id INT,external_id String,name String,short_name String,lat Double,lon Double,rental_methods Array<String>,capacity INT,electric_bike_surcharge_waiver Boolean,is_charging Boolean,eightd_has_key_dispenser Boolean,has_kiosk Boolean,system_id String,language String,system_name String,system_short_name String,operator String,url String,start_date String,phone_number String,email String,license_url String,timezone String)\nROW FORMAT DELIMITED\nFIELDS TERMINATED BY ','\nCOLLECTION ITEMS TERMINATED BY '||'\nSTORED AS TEXTFILE\nLOCATION '/user/fall2019/sahilgogna/sprint2'\ntblproperties(\"skip.header.line.count\"=\"1\",\"serialization.null.format\"=\"\")");

    public static void constructHiveTable() throws SQLException {
            try {
                Class.forName(driverName);
            } catch (ClassNotFoundException e){
                e.printStackTrace();
                System.exit(1);
            }
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            String dropQuery = "DROP TABLE IF EXISTS fall2019_sahilgogna.external_station_information";
            statement.execute(STRICT_MODE_QUERY);
            statement.execute(dropQuery);
            statement.execute(createQuery);
    }
}
