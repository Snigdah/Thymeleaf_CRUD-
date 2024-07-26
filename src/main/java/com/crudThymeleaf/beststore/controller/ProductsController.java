package com.crudThymeleaf.beststore.controller;

import com.crudThymeleaf.beststore.models.Product;
import com.crudThymeleaf.beststore.models.ProductDto;
import com.crudThymeleaf.beststore.services.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "products/CreateProduct";
    }

    @GetMapping("/details")
    public String showProductDetails(@RequestParam("productId") int productId,
                                     HttpSession session,
                                     Model model) {
//        List<Product> products = (List<Product>) session.getAttribute("products");
//        if (products != null) {
//            for (Product product : products) {
//                if (product.getId() == productId) {
//                    model.addAttribute("product", product);
//                    break;
//                }
//            }
//        }
        model.addAttribute("product", productId);
        return "products/ProductDetails"; // this will load ProductDetails.html template
    }
}
