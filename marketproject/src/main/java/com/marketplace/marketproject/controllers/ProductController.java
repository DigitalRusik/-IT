package com.marketplace.marketproject.controllers;
import com.marketplace.marketproject.models.Product;
import com.marketplace.marketproject.models.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/api/products")
    public String ApiProduct(HttpSession session, @RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productinfo"; // Добавить HTML
    }
}
