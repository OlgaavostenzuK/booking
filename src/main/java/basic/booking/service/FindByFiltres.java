package basic.booking.service;

import basic.booking.domain.QSubject;
import basic.booking.domain.Subject;
import basic.booking.repos.SubjectRepo;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindByFiltres implements SubjectRepo {
    @Autowired
    private SubjectRepo subjectRepo;

    QSubject qSubject=QSubject.subject;

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


    public Iterable<Subject> findBySelected() {

        if(filterRegion==null & filterPrice==null) {
            return subjectRepo.findAll();
        }else if(filterRegion!=null & filterPrice!=null){
            return subjectRepo.findAll(qSubject.price.loe(filterPrice).and(qSubject.region.eq(filterRegion)));
        } else if (filterRegion==null & filterPrice!=null) {
            return subjectRepo.findAll(qSubject.price.loe(filterPrice));
        }else if (filterRegion!=null & filterPrice==null) {
            return subjectRepo.findAll(qSubject.region.eq(filterRegion));
        }else  {return  subjectRepo.findAll();}
    }


    @Override
    public Subject findByIDSubject(Integer idSubject) {
        return null;
    }

    @Override
    public List<Subject> findByPriceIsLessThanEqual(Integer filterPrice) {
        return null;
    }

    @Override
    public Optional<Subject> findOne(Predicate predicate) {
        return Optional.empty();
    }

    @Override
    public Iterable<Subject> findAll(Predicate predicate) {
        return null;
    }

    @Override
    public Iterable<Subject> findAll(Predicate predicate, Sort sort) {
        return null;
    }

    @Override
    public Iterable<Subject> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
        return null;
    }

    @Override
    public Iterable<Subject> findAll(OrderSpecifier<?>... orderSpecifiers) {
        return null;
    }

    @Override
    public Page<Subject> findAll(Predicate predicate, Pageable pageable) {
        return null;
    }

    @Override
    public long count(Predicate predicate) {
        return 0;
    }

    @Override
    public boolean exists(Predicate predicate) {
        return false;
    }

    @Override
    public <S extends Subject> S save(S s) {
        return null;
    }

    @Override
    public <S extends Subject> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Subject> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Subject> findAll() {
        return null;
    }

    @Override
    public Iterable<Subject> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Subject subject) {

    }

    @Override
    public void deleteAll(Iterable<? extends Subject> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
