package za.ac.cput.factory;

import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

public class OrderItemFactory {
    public static OrderItem createOrderItem(
            int orderItemID,
            int productID,
            double price,
            int quantity
    ){
        if(Helper.isValidPrice(price) ){
            return null;
        }
        return new OrderItem.Builder()
                .setOrderItemID(orderItemID)
                .setProductID(productID)
                .setPrice(price)
                .setQuantity(quantity)
                .build();
    }
}
