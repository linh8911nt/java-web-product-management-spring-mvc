package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller

public class ProductController {
    private ProductService productService = new ProductService();
    private static Pattern pattern;
    private Matcher matcher;
    private static final String CODE_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]$";

    public ProductController() {
        pattern = Pattern.compile(CODE_REGEX);
    }

    @GetMapping("/list")
    public String showProductList(ModelMap modelMap){
        List<Product> products = this.productService.findAll();

        modelMap.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/showFormAddProduct")
    public String showFormAddProduct(ModelMap modelMap){
        modelMap.addAttribute("addProduct", new Product());
        return "addProduct";
    }

    @ModelAttribute("categories_id")
    public Map<Integer, String> getCategory_id(){
        Map<Integer, String> categories_id = new HashMap<>();
        categories_id.put(1, "Guitars");
        categories_id.put(2, "Basses");
        categories_id.put(3, "Drums");
        return categories_id;
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("addProduct") Product product, ModelMap modelMap){
        boolean isValid = this.validate(product.getCode());
        int result = 0;
        if (isValid) {
            result = this.productService.addProduct(product);
        }
        if (result == 0){
            modelMap.addAttribute("message", "Add Fail!");
        } else {
            modelMap.addAttribute("message", "Add Success!");
        }

        return "addProduct";
    }

    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
