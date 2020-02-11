package basic.booking.controller;

import basic.booking.Application;
import basic.booking.domain.MetroStation;
import basic.booking.domain.Subject;
import basic.booking.domain.User;
import basic.booking.repos.SubjectRepo;

import basic.booking.service.FindByFiltres;
import basic.booking.service.SetDate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.*;

@Controller
public class ReestrController {
    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private FindByFiltres findByFiltres;

    @Autowired
    private SetDate setDate;

    @GetMapping("/")
    public String mainReestr(@RequestParam(required = false) Integer filterPrice,
                             @RequestParam(required = false) String filterRegion,
                             @RequestParam(required = false) Date wanteddate,
//                             @RequestParam(required = false) Integer filterArea,
//                             @RequestParam(required = false) String filterMedia,
                             Model model){


        Iterable<Subject> subjects =subjectRepo.findAll();

        if (wanteddate == null) {
            wanteddate = setDate.setCurrentDate();
        }

        findByFiltres.setWanteddateSelected(wanteddate);


        if (filterPrice!=null && !filterPrice.equals("")){
            findByFiltres.setPriceSelected(filterPrice);
        }

        if (filterRegion!=null && !filterRegion.isEmpty()){
            findByFiltres.setRegionSelected(filterRegion);
        }

        subjects=findByFiltres.findBySelected();


        model.addAttribute("subjects", subjects);
        model.addAttribute("filterPrice", filterPrice);
        model.addAttribute("wanteddate", wanteddate);
        model.addAttribute("filterRegion", filterRegion);

        findByFiltres.clearFilters();
        return "main-reestr";
    }
}




