package com.example.codefellowship.controller;

import com.example.codefellowship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class UserController {

@Autowired
    UserRepository userRepository;


@GetMapping("/users/{id}")
    public String getUserInfo(Model m, @PathVariable Integer id, Principal p) {
//    m.addAttribute("username",p.getName());
    m.addAttribute("user",userRepository.findById(id));
    return "users.html";

}

}
