package basic.booking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Subject {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer IDSubject;

    private String subjectName;
    private Integer price;
    private String region;
    private String address;
    private Integer area;
    private String info;
    private String media;


    protected Subject() {
    }

    public Subject(String subjectName, Integer price, String region, String address, Integer area, String info, String media) {
        this.subjectName = subjectName;
        this.price = price;
        this.region = region;
        this.address = address;
        this.area = area;
        this.info = info;
        this.media = media;
    }

    public Integer getIDSubject() {
        return IDSubject;
    }

    public void setIDSubject(Integer IDSubject) {
        this.IDSubject = IDSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }
}

