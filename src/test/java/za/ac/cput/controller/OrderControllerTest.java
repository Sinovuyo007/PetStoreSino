package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.Status;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.OrderItemFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderControllerTest {

    private static Order order;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/petstoretest/order";

    @BeforeAll
    public static void setUp() {
        LocalDate orderDate = LocalDate.now();
        LocalDate deliveryDate = LocalDate.parse("2025-05-10");
        OrderItem orderItem = OrderItemFactory.createOrderItem(1,1,100.00,5);
        Status status = Status.Busy;
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        order = OrderFactory.createOrder(1,1,orderDate,deliveryDate,8000,orderItems,status);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url,order, Order.class);
        assertNotNull(postResponse);
        Order createdLibrary = postResponse.getBody();
        assertEquals(order.getOrderID(),createdLibrary.getOrderID());
        System.out.println("Created " + createdLibrary.toString());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + order.getOrderID();
        ResponseEntity<Order> readOrder =  this.restTemplate.getForEntity(url, Order.class);
        assertNotNull(readOrder);
        System.out.println(readOrder.toString());
    }

    @Test
    void c_update() {
        Order updateOrder = new Order.Builder().copy(order).setTotalPrice(700.00).build();
        String url = BASE_URL + "/update/";
        ResponseEntity<Order> updatedOrder = restTemplate.postForEntity(url, updateOrder, Order.class);
        assertNotNull(updatedOrder);
        System.out.println(updatedOrder.toString());
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + order.getOrderID();
        restTemplate.delete(url);

        String readUrl = BASE_URL + "/read/" + order.getOrderID();
        ResponseEntity<Order> response = restTemplate.getForEntity(readUrl, Order.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("true");
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Order[]> response = this.restTemplate.getForEntity(url,Order[].class);
        for (Order order : response.getBody()){
            System.out.println(order);
        }
    }
}