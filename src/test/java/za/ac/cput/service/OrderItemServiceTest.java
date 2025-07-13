package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderItemFactory;

import javax.swing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderItemServiceTest {
    @Autowired
    private OrderItemService service;
private static OrderItem orderItem = OrderItemFactory.createOrderItem(1,1,123.99,4);
    @Test
    void a_create() {
        OrderItem created = service.create(orderItem);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        OrderItem created = service.read(orderItem.getOrderItemID());
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void c_update() {
        OrderItem newOrderItem =new OrderItem.Builder().copy(orderItem).setPrice(200.00).build();
        OrderItem updatedOrderItem = service.update(newOrderItem);
        assertNotNull(updatedOrderItem);
        System.out.println(updatedOrderItem);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean deleted = service.delete(orderItem.getOrderItemID());
        assertNotNull(deleted);
        System.out.println(deleted);
    }

    @Test
    void e_findByPrice() {
        assertNotNull(service.findByPrice(200.00));
        System.out.println(service.findByPrice(200.00));
    }

    @Test
    void f_findByQuantity() {
        assertNotNull(service.findByQuantity(4));
        System.out.println(service.findByQuantity(4));
    }

    @Test
    void g_getAll() {
        List<OrderItem> orderItemList = service.getAll();
        assertNotNull(orderItemList);

        for (OrderItem s : orderItemList){
            System.out.println(s);
        }
    }
}