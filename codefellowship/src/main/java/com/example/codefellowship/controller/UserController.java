package com.example.codefellowship.controller;

import com.example.codefellowship.model.Post;
import com.example.codefellowship.repository.ApplicationUserRepository;
import com.example.codefellowship.repository.PostRepository;
import com.example.codefellowship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class UserController {

@Autowired
    UserRepository userRepository;

@Autowired
    ApplicationUserRepository applicationUserRepository;
@Autowired
PostRepository postRepository;

@GetMapping("/users")
    public String getUserInfo(Model m,  Principal p) {
    m.addAttribute("username",p.getName());
    m.addAttribute("user",applicationUserRepository.findByUsername(p.getName()));
    return "users.html";

}

@PostMapping("/users")
    public RedirectView addPost(Principal p,@RequestParam String body){
    Post newPost= new Post(body,applicationUserRepository.findByUsername(p.getName()));
      postRepository.save(newPost);
      return new RedirectView("/users");
}

}
