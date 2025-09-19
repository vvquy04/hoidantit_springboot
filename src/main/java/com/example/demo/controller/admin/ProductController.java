package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.service.ProductService;
import com.example.demo.service.UploadService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController( UploadService uploadService, ProductService productService) {
       
        this.uploadService = uploadService;
        this.productService = productService;
    }

    @RequestMapping("/admin/product")
    public String getProductPage(Model model) {
        List<Product> products = this.productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateproductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping(value = "/admin/product/create")
    public String createproductPage(Model model, @ModelAttribute("newProduct") @Valid Product hoidanit,
            BindingResult bindingResult,
            @RequestParam("hoidanitFile") MultipartFile file) {
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getField() + " - " + error.getDefaultMessage());
        }
        if(bindingResult.hasErrors()){
            return "/admin/product/create";
        }
        String img = this.uploadService.handleSaveUploadFile(file, "product");
        hoidanit.setImage(img);
        this.productService.handlSaveProduct(hoidanit);
        return "redirect:/admin/product";
        
    }

    @RequestMapping("/admin/product/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("id", id);
        model.addAttribute("product", product);
        return "admin/product/detail";
    }

    @RequestMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("newProduct", product);
        return "admin/product/update";
    }

    @PostMapping("/admin/product/update")
    public String updateProductPage(Model model, @ModelAttribute("newProduct") @Valid Product hoidanit,
            BindingResult bindingResult,
            @RequestParam("hoidanitFile") MultipartFile file) {
        if(bindingResult.hasErrors()){
            return "admin/product/update";
        }
        Product product = this.productService.getProductById(hoidanit.getId());
        if (product != null) {
            if(!file.isEmpty()){
                String img = this.uploadService.handleSaveUploadFile(file, "product");
                product.setImage(img);
            }
            product.setName(hoidanit.getName());
            product.setPrice(hoidanit.getPrice());
            product.setDetailDesc(hoidanit.getDetailDesc());
            product.setShortDesc(hoidanit.getShortDesc());
            product.setQuantity(hoidanit.getQuantity());
            product.setFactory(hoidanit.getFactory());
            product.setTarget(hoidanit.getTarget());
            this.productService.handlSaveProduct(product);
        }
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        // product product = new product();
        // product.setId(id);
        model.addAttribute("newProduct", new Product());
        return "admin/product/delete";
    }

    @PostMapping("/admin/product/delete/{id}")
    public String postDeleteProductPage(Model model, @ModelAttribute("newProduct") Product hoidanit) {
        this.productService.deleteAProduct(hoidanit.getId());
        return "redirect:/admin/product";
    }
}
