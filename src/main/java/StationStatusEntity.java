public class StationStatusEntity {

    private String station_id;
    private int num_bikes_available;
    private int num_ebikes_available;
    private int num_bikes_disabled;
    private int num_docks_available;
    private int num_docks_disabled;
    private int is_installed;
    private int is_renting;
    private int is_returning;
    private int last_reported;
    private boolean eightd_has_available_keys;
    private boolean is_charging;

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public int getNum_bikes_available() {
        return num_bikes_available;
    }

    public void setNum_bikes_available(int num_bikes_available) {
        this.num_bikes_available = num_bikes_available;
    }

    public int getNum_ebikes_available() {
        return num_ebikes_available;
    }

    public void setNum_ebikes_available(int num_ebikes_available) {
        this.num_ebikes_available = num_ebikes_available;
    }

    public int getNum_bikes_disabled() {
        return num_bikes_disabled;
    }

    public void setNum_bikes_disabled(int num_bikes_disabled) {
        this.num_bikes_disabled = num_bikes_disabled;
    }

    public int getNum_docks_available() {
        return num_docks_available;
    }

    public void setNum_docks_available(int num_docks_available) {
        this.num_docks_available = num_docks_available;
    }

    public int getNum_docks_disabled() {
        return num_docks_disabled;
    }

    public void setNum_docks_disabled(int num_docks_disabled) {
        this.num_docks_disabled = num_docks_disabled;
    }

    public int getIs_installed() {
        return is_installed;
    }

    public void setIs_installed(int is_installed) {
        this.is_installed = is_installed;
    }

    public int getIs_renting() {
        return is_renting;
    }

    public void setIs_renting(int is_renting) {
        this.is_renting = is_renting;
    }

    public int getIs_returning() {
        return is_returning;
    }

    public void setIs_returning(int is_returning) {
        this.is_returning = is_returning;
    }

    public boolean isEightd_has_available_keys() {
        return eightd_has_available_keys;
    }

    public void setEightd_has_available_keys(boolean eightd_has_available_keys) {
        this.eightd_has_available_keys = eightd_has_available_keys;
    }


    public int getLast_reported() {
        return last_reported;
    }

    public void setLast_reported(int last_reported) {
        this.last_reported = last_reported;
    }

    public boolean isIs_charging() {
        return is_charging;
    }

    public void setIs_charging(boolean is_charging) {
        this.is_charging = is_charging;
    }
}
