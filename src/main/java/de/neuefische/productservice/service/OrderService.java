package de.neuefische.productservice.service;

import de.neuefische.productservice.model.Order;
import de.neuefische.productservice.model.Product;
import de.neuefische.productservice.orderDb.OrderDB;
import de.neuefische.productservice.productDb.ProductDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderDB orderDB;
    private ProductDb productDb;

    @Autowired
    public OrderService(OrderDB orderDB){
        this.orderDB = orderDB;
    }

    public List<Order> listOrders(){
        return orderDB.listOrders();
    }

    public void addOrder(Order order){
        orderDB.addOrderToOrderDb(order);
    }


}
