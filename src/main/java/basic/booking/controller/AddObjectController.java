package basic.booking.controller;

import basic.booking.domain.Subject;
import basic.booking.domain.User;
import basic.booking.repos.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AddObjectController {
    @Autowired
    private SubjectRepo subjectRepo;


    @GetMapping("/add-new-object")
    public String addNewObject(){return "add-new-object";}


    //    TODO: для проверки - убрать userToControl
    @PostMapping("/add-new-object")
    public void add(
            @AuthenticationPrincipal User userToControl,
            @RequestParam String chooseSubjectName,
            @RequestParam Integer choosePrice,
            @RequestParam String chooseRegion,
            @RequestParam String chooseAddress,
            @RequestParam Integer chooseArea,
            @RequestParam String chooseInfo,
            @RequestParam(required = false) String chooseMedia){
        Subject subject=new Subject(chooseSubjectName,choosePrice,chooseRegion, chooseAddress, chooseArea, chooseInfo,chooseMedia, userToControl);
        subjectRepo.save(subject);
    }

}




