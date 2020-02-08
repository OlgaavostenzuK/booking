package basic.booking.repos;

import basic.booking.domain.Subject;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SubjectRepo extends CrudRepository<Subject, Integer>, QuerydslPredicateExecutor<Subject> {
    List<Subject> findByPriceIsLessThanEqual(Integer filterPrice);

    Subject findByIDSubject(Integer idSubject);

}


