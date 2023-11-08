package com.marketplace.marketproject.controllers;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PageController {
    @GetMapping("/")
    public String main(HttpSession session,Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/greeting";
        }
        else
        {
            return "redirect:/mainpage";
        }
    }
    @GetMapping("/greeting")
    public String login(HttpSession session,Model model) {
        if (session.getAttribute("username") == null) {
            return "greeting";
        }
        else
        {
            return "redirect:/mainpage";
        }
    }
    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }
}
