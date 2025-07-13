package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderItemFactory;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderItemControllerTest {
    private static OrderItem orderItem;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/petstoretest/orderItem";

    @BeforeAll
    static void setUp() {
        orderItem = OrderItemFactory.createOrderItem(1,1,100.00,5);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";

        ResponseEntity<OrderItem> postResponse = this.restTemplate.postForEntity(url,orderItem, OrderItem.class);
        assertNotNull(postResponse);
        OrderItem orderItemSaved = postResponse.getBody();
        assertEquals(orderItem.getOrderItemID(),orderItemSaved.getOrderItemID());
        System.out.println("Created " + orderItemSaved.toString());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + orderItem.getOrderItemID();
        ResponseEntity<OrderItem> readOrderItem =  this.restTemplate.getForEntity(url, OrderItem.class);
        assertNotNull(readOrderItem);
        System.out.println(readOrderItem);
    }

    @Test
    void c_update() {
        OrderItem updateOrderItem = new OrderItem.Builder().copy(orderItem).setPrice(700).build();
        String url = BASE_URL + "/update/";
        ResponseEntity<OrderItem> updatedOrderItem = restTemplate.postForEntity(url, updateOrderItem, OrderItem.class);
        assertNotNull(updatedOrderItem);
        System.out.println(updatedOrderItem);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + orderItem.getOrderItemID();
        restTemplate.delete(url);

        String readUrl = BASE_URL + "/read/" + orderItem.getOrderItemID();
        ResponseEntity<OrderItem> response = restTemplate.getForEntity(readUrl, OrderItem.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("true");
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getAll";
        List orderItems = restTemplate.getForObject(url, List.class);
        assertNotNull(orderItems);
        System.out.println(orderItems);
    }
}