package de.neuefische.productservice.orderDb;

import de.neuefische.productservice.model.Order;
import de.neuefische.productservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDB {

    private List<Order> orders = new ArrayList<>();

    public List<Order> listOrders(){
        return orders;
    }

    public Optional<Order> getOrder(String id){
        for (Order order: orders) {
            if(order.getId().equals(id)){
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    public void addOrderToOrderDb(Order order){
        orders.add(order);
    }
}
