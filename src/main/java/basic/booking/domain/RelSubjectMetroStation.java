package basic.booking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RelSubjectMetroStation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer IDRelSubjectMetroStation;

    private Integer IDMetroStation;
    private Integer IDSubject;

    protected RelSubjectMetroStation() {
    }

    public RelSubjectMetroStation(Subject subject, MetroStation metroStation) {
        this.IDSubject = subject.getIDSubject();
        this.IDMetroStation = metroStation.getIDMetroStation();
    }
}
