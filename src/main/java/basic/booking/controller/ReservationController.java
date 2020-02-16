package basic.booking.controller;

import basic.booking.domain.Reserve;
import basic.booking.domain.User;
import basic.booking.repos.ReserveRepo;
import basic.booking.repos.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ReservationController {
    @Autowired
    private ReserveRepo reserveRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @GetMapping("/reservation/{IDSubjectForReserve}")
    public String reserveSubject(
            @PathVariable Integer IDSubjectForReserve, Map<String, Integer> model){
        model.put("IDSubjectForReserve",IDSubjectForReserve);
        return "reservation";
    }

    @PostMapping("/reservation/**")
    public String submitReserve(
            @RequestParam Date wanteddate,
            @RequestParam Integer IDSubjectForReserve,
            @AuthenticationPrincipal User user,
            Map<String, Object> model){

        List<Reserve> res = reserveRepo.tryReserves(wanteddate,subjectRepo.findByIDSubject(IDSubjectForReserve));

        if (res.size()==0) {
            Reserve reserve = new Reserve(wanteddate, subjectRepo.findByIDSubject(IDSubjectForReserve), user);
            reserveRepo.save(reserve);
            return "reserve-go";
        } else {
            return "reserve-no";
        }

    }

    @GetMapping("/reservation")
    public String addNewObject(){return "reservation";}

}




