package basic.booking.repos;

import basic.booking.domain.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;


public interface ReserveRepo extends CrudRepository<Reserve, Integer>, JpaRepository<Reserve, Integer> {

    @Query("select r from Reserve r where r.date=?1")
    Iterable<Reserve> reserves(Date date);

}


