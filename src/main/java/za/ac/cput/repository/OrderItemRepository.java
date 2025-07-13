package za.ac.cput.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.OrderItem;

import java.util.Optional;

@Repository
public interface OrderItemRepository  extends JpaRepository<OrderItem, Integer> {
    Optional<OrderItem> findByPrice(double price);
    Optional<OrderItem> findByQuantity(int quantity);
}
