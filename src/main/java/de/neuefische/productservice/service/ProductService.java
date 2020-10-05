package de.neuefische.productservice.service;

import de.neuefische.productservice.model.Product;
import de.neuefische.productservice.productDb.ProductDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductDb productDb;

    @Autowired
    public ProductService(ProductDb productDb){
        this.productDb = productDb;
    }

    public List<Product> list(String searchParam){
        if(searchParam == null){
            return productDb.listProducts();
        }
        return productDb.searchProducts(searchParam);
        /*
        List<Product> productsContainingSearchParam = new ArrayList<>();
        for (Product product: productDb.listProducts()) {
            if(product.getId().contains(searchParam)){
                productsContainingSearchParam.add(product);
            }
        }
        return productsContainingSearchParam;

         */
    }

    public Optional<Product> getProduct(String id){
        return productDb.getProduct(id);
    }


}
