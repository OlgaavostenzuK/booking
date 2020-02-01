package basic.booking.repos;

import basic.booking.domain.MetroStation;
import org.springframework.data.repository.CrudRepository;


public interface MetroStationRepo extends CrudRepository<MetroStation, Integer> {

}
