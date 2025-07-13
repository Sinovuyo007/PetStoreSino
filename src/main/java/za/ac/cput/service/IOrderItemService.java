package za.ac.cput.service;

import za.ac.cput.domain.OrderItem;
import za.ac.cput.service.IService;
import java.util.List;
import java.util.Optional;

public interface IOrderItemService extends IService<OrderItem,Integer> {
    List<OrderItem>getAll();
    Optional<OrderItem> findByPrice(double price);

    Optional<OrderItem> findByQuantity(int quantity);
}
