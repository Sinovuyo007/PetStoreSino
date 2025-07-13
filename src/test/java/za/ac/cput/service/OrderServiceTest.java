package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Status;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.OrderItemFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest()
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderServiceTest {
    @Autowired
    private OrderService service;

    private static OrderItem orderItem = OrderItemFactory.createOrderItem(1,1,123.99,4);
    private static LocalDate orderDate = LocalDate.now();
    private static LocalDate deliveryDate = LocalDate.parse("2025-05-10");
    private static Status status = Status.Busy;
    private static List<OrderItem> orderItems = new ArrayList<>();
    @BeforeAll
    static void addItems(){
        orderItems.add(orderItem);
    }
    private static Order order = OrderFactory.createOrder(1,1,orderDate,deliveryDate,8000,orderItems,status);

    @Test
    void a_create() {
        Order created = service.create(order);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Order read = service.read(order.getOrderID());
    }

    @Test
    void c_update() {
        Order newOrder = new Order.Builder().copy(order).setTotalPrice(30000.00).build();
        Order updatedOrder = service.update(newOrder);
        assertNotNull(updatedOrder);
        System.out.println(updatedOrder);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean deleted = service.delete(order.getOrderID());
        assertNotNull(deleted);
        System.out.println(deleted);
    }

    @Test
    void e_getAll() {
        System.out.println(service.getAll());
    }

    @Test
    void f_findByOrderDate() {
        assertNotNull(service.findByOrderDate(orderDate));
        System.out.println(service.findByOrderDate(orderDate));
    }

    @Test
    void g_findByDeliveryDate() {
        assertNotNull(service.findByDeliveryDate(deliveryDate));
        System.out.println(service.findByDeliveryDate(deliveryDate));
    }

    @Test
    void h_findByTotalPrice() {
        assertNotNull(service.findByTotalPrice(order.getTotalPrice()));
        System.out.println(service.findByTotalPrice(order.getTotalPrice()));
    }

    @Test
    void i_findByStatus() {
        assertNotNull(service.findByStatus(status));
        System.out.println(service.findByStatus(status));
    }
}