package com.marketplace.marketproject.controllers;

import com.marketplace.marketproject.models.User;
import com.marketplace.marketproject.models.UserRepository;
import com.marketplace.marketproject.models.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GreetingController {
    @Autowired
    private UserRepository userRepository;
    String response = "false";
    String hashpass = "";
    @ResponseBody
    @PostMapping("/api/greeting")
    public String greeting(HttpSession session,@RequestParam(name = "username", required = false) String username, @RequestParam(name="email", required = false) String email, @RequestParam(name="pass", required = false) String pass, Model model) {
        username = username.trim();
        email = email.trim();
        email = email.toLowerCase();
        pass = pass.trim();
        User registerUser = new User();
        registerUser.setEmail(email);
        registerUser.setPassword(pass);
        registerUser.setName(username);
        registerUser.setDelete(false);
        UserService.createUser(registerUser);
        session.setAttribute("username", username);
        return "Ваш аккаунт зарегистрирован!";
    }
}

