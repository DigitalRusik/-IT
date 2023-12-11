package com.marketplace.marketproject.controllers;
import javax.servlet.http.HttpSession;

import com.marketplace.marketproject.models.ProductService;
import com.marketplace.marketproject.models.User;
import com.marketplace.marketproject.models.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final ProductService productService;
    private final UserService userService;
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
    public String login(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "greeting";
        }
        else
        {

            if (session.getAttribute("username").equals("Administrator"))
                return "redirect:/adminPage";
            else return "redirect:/mainpage";
        }
    }
    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }
    @GetMapping("/adminPage")
    public String adminSignIn(HttpSession session, Model model) {
        if (session.getAttribute("username").equals("Administrator")) {
            return "adminPage";
        }
        else
        {
            return "redirect:/greeting";
        }
    }
    @GetMapping("/adminPage/userList")
    public String adminUserlist(HttpSession session, @RequestParam(name = "username", required = false) String username, Model model) {
        if (session.getAttribute("username").equals("Administrator")) {
            model.addAttribute("users", userService.getAllUsers(username));
            return "userList";
        }
        else
        {
            return "redirect:/greeting";
        }
    }
    @GetMapping("/adminPage/productAdmin")
    public String adminProducts(HttpSession session, @RequestParam(name = "title", required = false) String title, Model model) {
        if (session.getAttribute("username").equals("Administrator")) {
            model.addAttribute("products", productService.getAllProducts(title));
            return "productAdmin";
        }
        else
        {
            return "redirect:/greeting";
        }
    }
    @PostMapping("/adminPage/productAdmin/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/adminPage/productAdmin";
    }
}
