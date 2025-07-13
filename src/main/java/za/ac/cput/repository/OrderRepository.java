package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Status;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer> {
    Optional<OrderItem> findByOrderDate(LocalDate orderDate);
    Optional<OrderItem> findByDeliveryDate(LocalDate deliveryDate);
    Optional<OrderItem> findByTotalPrice(double totalPrice);
    Optional<OrderItem> findByStatus(Status status);
}
