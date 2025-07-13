package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Status;
import za.ac.cput.repository.OrderRepository;
import za.ac.cput.service.IOrderService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    private OrderRepository orderRepository ;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;}

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order read(Integer id) {
        return orderRepository.getReferenceById(id);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public boolean delete(Integer id) {
        orderRepository.deleteById(id);
        return true;
    }
    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderItem> findByOrderDate(LocalDate orderDate) {
        return orderRepository.findByOrderDate(orderDate);
    }

    @Override
    public Optional<OrderItem> findByDeliveryDate(LocalDate deliveryDate) {
        return orderRepository.findByDeliveryDate(deliveryDate);
    }

    @Override
    public Optional<OrderItem> findByTotalPrice(double totalPrice) {
        return orderRepository.findByTotalPrice(totalPrice);
    }

    @Override
    public Optional<OrderItem> findByStatus(Status status) {
        return orderRepository.findByStatus(status);
    }


}
