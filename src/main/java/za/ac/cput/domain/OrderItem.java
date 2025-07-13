package za.ac.cput.domain;

import jakarta.persistence.*;

/*
     OrderItem class
     Author: Sinovuyo Mathungana (230143725)
*/
@Entity
public class OrderItem{
    @Id
    private int orderItemID;
    private int productID;
    private double price;
    private  int quantity;
    protected OrderItem(){}



    private OrderItem(Builder builder){
        this.orderItemID = builder.orderItemID;
        this.productID = builder.productID;
        this.price = builder.price;
        this.quantity = builder.quantity;
    }

    public int getOrderItemID() {
        return orderItemID;
    }

    public int getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemID=" + orderItemID +
                ", productID=" + productID +
                ", price=" + price +
                ", quantity="+ quantity+
                '}';
    }
    public static class Builder{
        private int orderItemID;
        private int productID;
        private double price;
        private  int quantity;

        public Builder setOrderItemID(int orderItemID) {
            this.orderItemID = orderItemID;
            return this;
        }

        public Builder setProductID(int productID) {
            this.productID = productID;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder copy(OrderItem orderitem){
            this.orderItemID = orderitem.orderItemID;
            this.productID = orderitem.productID;
            this.price = orderitem.price;
            this.quantity = orderitem.quantity;
            return this;
        }
        public OrderItem build(){return new OrderItem(this);}
    }
}

