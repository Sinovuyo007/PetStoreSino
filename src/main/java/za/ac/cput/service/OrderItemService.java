package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.OrderItemRepository;
import za.ac.cput.service.IOrderItemService;

import java.util.List;
import java.util.Optional;
@Service
public class OrderItemService implements IOrderItemService {
    private OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository){
        this.orderItemRepository =orderItemRepository;
    }


    @Override
    public OrderItem create(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem read(Integer id) {
        return orderItemRepository.getReferenceById(id);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public boolean delete(Integer id) {
        orderItemRepository.deleteById(id);
        return true;
    }
    @Override
    public Optional<OrderItem> findByPrice(double price) {
        return orderItemRepository.findByPrice(price);
    }

    @Override
    public Optional<OrderItem> findByQuantity(int quantity) {
        return orderItemRepository.findByQuantity(quantity);
    }

    @Override
    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

}
