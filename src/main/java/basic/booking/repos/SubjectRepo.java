package basic.booking.repos;

import basic.booking.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SubjectRepo extends CrudRepository<Subject, Integer>, JpaRepository<Subject, Integer>{
    Subject findByIDSubject(Integer idSubject);

    @Query("select s from Subject s where s.region = ?1 and s.price <= ?2")
    List<Subject> queryByRegionAAndPrice(String region, Integer price);

    @Query("select s from Subject s where s.region = ?1")
    List<Subject> queryByRegion(String region);

    @Query("select s from Subject s where s.price <= ?1")
    List<Subject> queryByPrice(Integer price);

}


