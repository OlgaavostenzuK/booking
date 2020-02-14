package basic.booking.controller;

import basic.booking.domain.Role;
import basic.booking.domain.Subject;
import basic.booking.domain.User;
import basic.booking.repos.SubjectRepo;

import basic.booking.repos.UserRepo;
import basic.booking.service.FindByFiltres;
import basic.booking.service.SetDate;
import basic.booking.service.WorkClassifierFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.sql.Date;
import java.util.Collections;
import java.util.Map;

@Controller
public class ReestrController {
    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private FindByFiltres findByFiltres;

    @Autowired
    private SetDate setDate;

    @Autowired
    private WorkClassifierFile workClassifierFile;


    private static boolean isAdminAct = false;


    Iterable<String> regions;

    @GetMapping("/")
    public String mainReestr(@RequestParam(required = false) Integer filterPrice,
                             @RequestParam(required = false) String filterRegion,
                             @RequestParam(required = false) Date wanteddate,


//                             @RequestParam(required = false) Integer filterArea,
//                             @RequestParam(required = false) String filterMedia,
                             Model model) {


        Iterable<Subject> subjects = subjectRepo.findAll();

        if (wanteddate == null) {
            wanteddate = setDate.setCurrentDate();
        }

        findByFiltres.setWanteddateSelected(wanteddate);


        if (filterPrice != null && !filterPrice.equals("")) {
            findByFiltres.setPriceSelected(filterPrice);
        }

        if (filterRegion != null && !filterRegion.isEmpty()) {
            findByFiltres.setRegionSelected(filterRegion);
        }

        subjects = findByFiltres.findBySelected();


        model.addAttribute("subjects", subjects);
        model.addAttribute("filterPrice", filterPrice);
        model.addAttribute("wanteddate", wanteddate);
        model.addAttribute("filterRegion", filterRegion);

        Iterable<String> listregions = this.regions;
        model.addAttribute("listregions", listregions);

        findByFiltres.clearFilters();
        return "main-reestr";
    }

    @GetMapping("/start")
    public String start() {
        return "admin";
    }

}

//        List<String> listRegions=workClassifierFile.readFile("src/main/resources/classifiers/metrostations.txt");
//        this.regions=listRegions;






