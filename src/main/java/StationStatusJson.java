
public class StationStatusJson {
    private Long last_updated;
    private int ttl;
    private StationStatusAux data;

    public Long getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Long last_updated) {
        this.last_updated = last_updated;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public StationStatusAux getData() {
        return data;
    }

    public void setData(StationStatusAux data) {
        this.data = data;
    }
}
