package za.ac.cput.service;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Status;
import za.ac.cput.service.IService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IOrderService extends IService<Order,Integer> {
    List<Order>getAll();
    Optional<OrderItem> findByOrderDate(LocalDate orderDate);

    Optional<OrderItem> findByDeliveryDate(LocalDate deliveryDate);

    Optional<OrderItem> findByTotalPrice(double totalPrice);

    Optional<OrderItem> findByStatus(Status status);
}
