package com.example.codefellowship.controller;

import com.example.codefellowship.model.ApplicationUser;
import com.example.codefellowship.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public  String getSignUpPage(){

        return "signup.html";
    }

    @GetMapping("/login")
    public String getSignInPage(){
        return "signin.html";
    }


    @PostMapping("/signup")
    public RedirectView signup(
            @RequestParam(value ="username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "firstname") String firstname,
            @RequestParam(value = "lastname") String lastname,
            @RequestParam(value = "dateofbirth") String dateofbirth,
            @RequestParam(value = "bio") String bio)
    {

        ApplicationUser newUser=new ApplicationUser(username,bCryptPasswordEncoder.encode(password),firstname,lastname,dateofbirth,bio);

        applicationUserRepository.save(newUser);

        return new RedirectView("/login");
    }

}
