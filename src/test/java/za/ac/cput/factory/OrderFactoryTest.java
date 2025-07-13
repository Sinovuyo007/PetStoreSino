package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    private static LocalDate orderDate = LocalDate.now();
    private static LocalDate deliveryDate = LocalDate.parse("2025-05-10");
    private static OrderItem orderItem = OrderItemFactory.createOrderItem(1,1,100.00,5);
    private static Status status = Status.Busy;
    private static List<OrderItem> orderItems = new ArrayList<>();
    @Test
    void createOrder() {
        orderItems.add(orderItem);
        Order order = OrderFactory.createOrder(1,1,orderDate,deliveryDate,8000,orderItems,status);
        assertNotNull(order);
        System.out.println(order.toString());
    }
}