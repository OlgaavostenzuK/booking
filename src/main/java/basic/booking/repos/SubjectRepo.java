package basic.booking.repos;

import basic.booking.domain.MetroStation;
import basic.booking.domain.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SubjectRepo extends CrudRepository<Subject, Integer> {
    List<Subject> findByPriceEqualsOrRegionEqualsOrAreaEqualsOrMediaEquals(Integer filterPrice, String filterRegion, Integer filterArea, String filterMedia);
    List<Subject> findByPriceIsLessThanEqual(Integer filterPrice);

    Subject findByIDSubject(Integer IDSubject);


}


