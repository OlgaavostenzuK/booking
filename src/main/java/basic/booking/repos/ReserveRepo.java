package basic.booking.repos;

import basic.booking.domain.Reserve;
import basic.booking.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;


public interface ReserveRepo extends CrudRepository<Reserve, Integer>, JpaRepository<Reserve, Integer> {

    @Query("select r from Reserve r where r.date=?1")
    Iterable<Reserve> reserves(Date date);

    @Query("select r from Reserve r where r.date=?1 and r.subject=?2")
    List<Reserve> tryReserves(Date date, Subject subject);


}


