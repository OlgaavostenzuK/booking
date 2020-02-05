package basic.booking.repos;

import basic.booking.domain.Reserve;
import basic.booking.domain.Subject;
import basic.booking.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;


public interface ReserveRepo extends CrudRepository<Reserve, Integer> {
    Date findAllByDate(Date wantedDate);


}


