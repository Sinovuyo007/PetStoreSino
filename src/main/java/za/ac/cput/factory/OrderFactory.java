package za.ac.cput.factory;

import java.time.LocalDate;
import java.util.List;

import za.ac.cput.domain.Status;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

public class OrderFactory {
    public static Order createOrder(
            int orderID,
            int userID,
            LocalDate orderDate,
            LocalDate deliveryDate,
            double totalPrice,
            List<OrderItem> items,
            Status status
    ){
        if(Helper.isValidDate(orderDate)
                ||Helper.isValidDate(deliveryDate)
                || items.isEmpty()
                || status == null){
            return null;
        }
        return new Order.Builder()
                .setOrderID(orderID)
                .setUserID(userID)
                .setOrderDate(orderDate)
                .setDeliveryDate(deliveryDate)
                .setTotalPrice(totalPrice)
                .setItems(items)
                .setStatus(status)
                .build();



    }
}
