package basic.booking.controller;

import basic.booking.domain.Role;
import basic.booking.domain.User;
import basic.booking.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(Map<String, Object> model){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @GetMapping("/error-admin")
    public String errorAdmin(){
        return "error-admin";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDB = userRepo.findByUsername(user.getUsername());

        if(userFromDB != null){
            model.put("message", "Пользователь с такими данными уже зарегистрирован!");
            return "registration";
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);

        return "redirect:/login";
    }

    @GetMapping("/admin")
    public String registrationAdmin(){
        return "admin";
    }

    @PostMapping("/admin")
    public String setAdmin(User user, Map<String, Object> model){


        if (userRepo.findAllByRoles(Role.ADMIN).size()==0) {

            user.setRoles(Collections.singleton(Role.ADMIN));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return "redirect:/login";

        } else {
            return "redirect:/error-admin";
        }
    }
}
