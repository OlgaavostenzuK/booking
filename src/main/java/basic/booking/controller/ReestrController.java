package basic.booking.controller;

import basic.booking.Application;
import basic.booking.domain.MetroStation;
import basic.booking.domain.Subject;
import basic.booking.domain.User;
import basic.booking.repos.SubjectRepo;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
public class ReestrController {
    @Autowired
    private SubjectRepo subjectRepo;


    @GetMapping("/")
    public String mainReestr(@RequestParam(required = false) Integer filterPrice,
//                             @RequestParam(required = false) String filterRegion,
//                             @RequestParam(required = false) Integer filterArea,
//                             @RequestParam(required = false) String filterMedia,
                             Model model){



        Iterable<Subject> subjects =subjectRepo.findAll();

        if(filterPrice!=null && !filterPrice.equals("")
//                & (filterRegion!=null && !filterRegion.isEmpty())
//                & filterArea!=null
//                & (filterMedia!=null && filterMedia.isEmpty())
        ){
//            subjects=subjectRepo.findByPriceEqualsOrRegionEqualsOrAreaEqualsOrMediaEquals(filterPrice, filterRegion, filterArea, filterMedia);
            subjects=subjectRepo.findByPriceIsLessThanEqual(filterPrice);
        }else {
            subjects=subjectRepo.findAll();
        }

        model.addAttribute("subjects", subjects);
        model.addAttribute("filterPrice", filterPrice);
//        model.addAttribute("filter", filterRegion);
//        model.addAttribute("filter", filterArea);
//        model.addAttribute("filter", filterMedia);

// TODO дата в фильтре календаря

//        Calendar calendar = Calendar.getInstance();
//        java.util.Date currentDate = calendar.getTime();
//        java.sql.Date date = new java.sql.Date(currentDate.getTime());
//        Application.setSqlDate(date);

        return "main-reestr";
    }
}




