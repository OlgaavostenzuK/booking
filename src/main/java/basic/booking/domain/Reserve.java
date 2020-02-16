package basic.booking.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Reserve {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer IDReserve;

    private Date date;

    @OneToOne(fetch =FetchType.EAGER)
    @JoinColumn (name = "IDSubject")
    private Subject subject;

    @OneToOne(fetch =FetchType.EAGER)
    @JoinColumn (name = "IDUser")
    private User user;

    public Reserve() {
    }

    public Reserve(Date date, Subject subject, User user) {
        this.date = date;
        this.subject = subject;
        this.user = user;
    }

    public Reserve(Subject subject) {
        this.date = null;
        this.subject = subject;
        this.user = null;

    }

    public Integer getIDReserve() {
        return IDReserve;
    }

    public void setIDReserve(Integer IDReserve) {
        this.IDReserve = IDReserve;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Subject getSubject() { return subject; }

    public void setSubject(Subject subject) { this.subject = subject; }
}
