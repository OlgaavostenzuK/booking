package basic.booking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MetroStation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer IDMetroStation;

    private String metroStationName;

    protected MetroStation() {
    }

    public MetroStation(String metroStationName) {
        this.metroStationName = metroStationName;
    }

    public Integer getIDMetroStation() {
        return IDMetroStation;
    }

    public void setIDMetroStation(Integer IDMetroStation) {
        this.IDMetroStation = IDMetroStation;
    }

    public String getMetroStationName() {
        return metroStationName;
    }

    public void setMetroStationName(String metroStationName) {
        this.metroStationName = metroStationName;
    }
}
