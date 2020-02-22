package basic.booking.controller;

import basic.booking.domain.Reserve;
import basic.booking.repos.ReserveRepo;
import basic.booking.service.FindByFiltres;
import basic.booking.service.SetDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@PreAuthorize("hasAuthority('ADMIN')")
@Controller
public class AdminReestrController {
    @Autowired
    ReserveRepo reserveRepo;

    @Autowired
    private FindByFiltres findByFiltres;

    @Autowired
    private SetDate setDate;

    @GetMapping("/admin-reestr")
    public String mainReestr(@RequestParam(required = false) Date wanteddate,
                             Model model) {
        if (wanteddate == null) {
            wanteddate = setDate.setCurrentDate();
        }

        Iterable<Reserve> reserves =reserveRepo.reserves(wanteddate);

        model.addAttribute("reserves", reserves);
        model.addAttribute("wanteddate", wanteddate);

        findByFiltres.clearFilters();
        return "admin-reestr";
    }

}






