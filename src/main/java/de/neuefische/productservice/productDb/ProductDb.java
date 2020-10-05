package de.neuefische.productservice.productDb;

import de.neuefische.productservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDb {

    private List<Product> products = new ArrayList<>(List.of(
            new Product("schuh", "Schuh"),
            new Product("gurke", "Gurke")
    ));

    public List<Product> listProducts(){
        return products;
    }

    public Optional<Product> getProduct(String id){
        for (Product product: products) {
            if(product.getId().equals(id)){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}
