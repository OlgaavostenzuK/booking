package basic.booking.controller;

import basic.booking.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("/userList")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("userList", userRepo.findAll());
        return "userList";
    }
}

