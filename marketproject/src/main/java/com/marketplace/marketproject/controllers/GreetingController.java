package com.marketplace.marketproject.controllers;

import com.marketplace.marketproject.models.User;
import com.marketplace.marketproject.models.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Optional;

@Controller
public class GreetingController {
    @Autowired
    private UserService userService;
    String response = "false";
    String hashpass = "";
    @ResponseBody
    @PostMapping("/api/greeting1")
    public String ApiLogin(HttpSession session,@RequestParam(name="lemail", required=false) String email, @RequestParam(name="lpass", required=false) String pass, Model model) {
        pass = pass.trim();
        String username = "";
        email = email.trim().toLowerCase();
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            username = user.getName();
            if (email.equals(user.getEmail()) && pass.equals(user.getPassword())) {
                session.setAttribute("username", username);
                response = "Вход выполнен!";
            } else {
                response = "Пароль неверный!";
            }
        } else {
            response = "Такого логина не существует!";
        }
        return response;
    }
    @GetMapping("/api/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/greeting";
    }
    @ResponseBody
    @PostMapping("/api/greeting")
    public String ApiRegister(HttpSession session,@RequestParam(name = "username", required = false) String username, @RequestParam(name="email", required = false) String email, @RequestParam(name="pass", required = false) String pass, Model model) {
        username = username.trim();
        email = email.trim();
        email = email.toLowerCase();
        pass = pass.trim();
        Optional<User> userOptional = UserService.getUserByEmail(email);
        User user = userOptional.orElse(null);
        if (user != null) {
            return "Такая почта уже существует!";
        }
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

