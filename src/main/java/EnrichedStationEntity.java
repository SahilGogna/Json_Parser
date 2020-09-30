import java.util.List;

public class EnrichedStationEntity {
    private StationInformationEntity stationInformationEntity;
    private StationStatusEntity stationStatusEntity;

    public EnrichedStationEntity(){}

    public EnrichedStationEntity(StationInformationEntity stationInformationEntity, StationStatusEntity stationStatusEntity) {
        this.stationInformationEntity = stationInformationEntity;
        this.stationStatusEntity = stationStatusEntity;
    }

    public StationInformationEntity getStationInformationEntity() {
        return stationInformationEntity;
    }

    public void setStationInformationEntity(StationInformationEntity stationInformationEntity) {
        this.stationInformationEntity = stationInformationEntity;
    }

    public StationStatusEntity getStationStatusEntity() {
        return stationStatusEntity;
    }

    public void setStationStatusEntity(StationStatusEntity stationStatusEntity) {
        this.stationStatusEntity = stationStatusEntity;
    }
}
