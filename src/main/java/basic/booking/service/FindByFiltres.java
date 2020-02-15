package basic.booking.service;

import basic.booking.domain.QSubject;
import basic.booking.domain.Reserve;
import basic.booking.domain.Subject;
import basic.booking.repos.ReserveRepo;
import basic.booking.repos.SubjectRepo;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class FindByFiltres {
    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private ReserveRepo reserveRepo;

    QSubject qSubject=QSubject.subject;

    private Date wanteddate=null;
    public void setWanteddateSelected(Date wanteddate) {
        this.wanteddate = wanteddate;
    }

    private Integer filterPrice=null;
    public void setPriceSelected(Integer filterPrice) {
        this.filterPrice = filterPrice;
    }

    private String filterRegion=null;
    public void setRegionSelected(String filterRegion){
        this.filterRegion = filterRegion;
    }


    public void clearFilters() {
        filterPrice=null;
        filterRegion=null;
    }

    public Iterable<Subject> queryByDate(Date date, List<Subject> foundedSubjects){
        List<Subject> subjects=foundedSubjects;
        Iterable<Reserve> reserves = reserveRepo.reserves(date); //весь резерв на выбранную дату

        for (Reserve reserve:reserves) {
            subjects.remove(reserve.getSubject());
        }
        return subjects;
    }

    public Iterable<Subject> reservedOnDate(Date date){
        List<Subject> subjects=new ArrayList<>();

        Iterable<Reserve> reserves = reserveRepo.reserves(date); //весь резерв на выбранную дату

        for (Reserve reserve:reserves) {
            subjects.add(reserve.getSubject());
        }
        return subjects;
    }




    public Iterable<Subject> findBySelected() {

        if(wanteddate!=null & filterRegion==null & filterPrice==null) { //только дата

            List<Subject> subjectsBeforeDate=subjectRepo.findAll(); // здесь все подходящие объекты до фильтра "дата" собираем
            return queryByDate(wanteddate, subjectsBeforeDate);


        }else if(wanteddate!=null & filterRegion!=null & filterPrice!=null){ //все фильтры

            List<Subject> subjectsBeforeDate=subjectRepo.queryByRegionAAndPrice(filterRegion, filterPrice); // здесь все подходящие объекты до фильтра "дата" собираем
            return queryByDate(wanteddate, subjectsBeforeDate);


        } else if (wanteddate!=null & filterRegion==null & filterPrice!=null) {

            List<Subject> subjectsBeforeDate=subjectRepo.queryByPrice(filterPrice); // здесь все подходящие объекты до фильтра "дата" собираем
            return queryByDate(wanteddate, subjectsBeforeDate);

        }else if (wanteddate!=null & filterRegion!=null & filterPrice==null) {

            List<Subject> subjectsBeforeDate=subjectRepo.queryByRegion(filterRegion); // здесь все подходящие объекты до фильтра "дата" собираем
            return queryByDate(wanteddate, subjectsBeforeDate);

        }else  {return  subjectRepo.findAll();}
    }




}
