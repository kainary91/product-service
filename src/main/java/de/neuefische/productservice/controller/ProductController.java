package de.neuefische.productservice.controller;

import de.neuefische.productservice.model.Product;
import de.neuefische.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    private List<Product> products;

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam(name="q", required = false) String searchParam){
        return productService.list(searchParam);
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable String id){
        Optional<Product> product = productService.getProduct(id);
        if(product.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found!");
        }
        return product.get();
    }
}
