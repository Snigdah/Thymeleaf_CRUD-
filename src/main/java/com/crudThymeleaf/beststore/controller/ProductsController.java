package com.crudThymeleaf.beststore.controller;

import com.crudThymeleaf.beststore.models.Product;
import com.crudThymeleaf.beststore.models.ProductDto;
import com.crudThymeleaf.beststore.services.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping({"", "/" +
            ""})
    public String showProductList(Model model){
        List<Product> products = productRepository.findAll();;
        model.addAttribute("products", products);
        return "products/index"; // this will load products.html template
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        return null;
    }
}
