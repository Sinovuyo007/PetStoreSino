package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.OrderItem;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemFactoryTest {
    private static OrderItem orderItem = OrderItemFactory.createOrderItem(1,1,123.99,4);
    @Test
    void createOrderItem() {
        assertNotNull(orderItem);
        System.out.println(orderItem);
    }
}