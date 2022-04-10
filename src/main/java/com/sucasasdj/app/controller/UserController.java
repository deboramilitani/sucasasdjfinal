package com.sucasasdj.app.controller;

import com.sucasasdj.app.model.User;
import com.sucasasdj.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    public String showLoginForm(User user) {
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userRepository.save(user);

        model.addAttribute("registerOk", true);

        return "redirect:/index";
    }

    @PostMapping("/login")
    public String login(@Valid User user, BindingResult result, HttpSession session) {

        User userDataBase= userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());

        if(userDataBase != null) {
            session.setAttribute("user", userDataBase);
            return "redirect:/home";
        }

        return "redirect:/index";
    }
}
