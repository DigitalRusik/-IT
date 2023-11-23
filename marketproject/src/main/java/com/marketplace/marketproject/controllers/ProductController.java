package com.marketplace.marketproject.controllers;
import com.marketplace.marketproject.models.Product;
import com.marketplace.marketproject.models.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @ResponseBody
    @GetMapping("/api/products")
    public String ApiProduct(HttpSession session, @RequestParam(name = "title", required = false) String title, @RequestParam(name = "description", required = false) String description) {
        return "products";
    }
}*/
