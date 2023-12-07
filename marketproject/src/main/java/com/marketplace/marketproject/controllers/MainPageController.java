package com.marketplace.marketproject.controllers;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainPageController {
    @GetMapping("/mainpage")
    public String mainpage(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            String user = (String) session.getAttribute("username");
            model.addAttribute("username", user);
            return "mainpage";
        } else {
            return "redirect:/greeting";
        }
    }
    /*@GetMapping("/mainpage/productlist")
    public String productlist(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            String user = (String) session.getAttribute("username");
            model.addAttribute("username", user);
            return "productlist";
        }
        else
        {
            return "redirect:/greeting";
        }
    }*/
    @GetMapping("/mainpage/basket")
    public String basket(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/greeting";
        }
        else
        {
            return "basket";
        }
    }
}
