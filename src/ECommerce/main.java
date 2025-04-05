package ECommerce;

import java.util.Date;
import java.util.List;

class Product {
    int productId;
    String productName;

    String description;
    int quantityLeft;
    Double price;
    Rating rating;
}
class Rating {
    Double stars;
    List<Review> reviews;
}

class Review {
    Customer customer;
    String comments;
    Double stars;
}

class Cart {

    int cartId;
    Customer customer;
    List<Item> items;
    Double totalAmount;

    void addItem() {

    }

    void deleteItem() {

    }
    void getItem() {

    }
    void checkOut() {

    }
}

class Item {
    int orderItemId;
    Product product;
    int quantity;
    Double amount;

    //updateQuantity();
}

class Order {
    Cart cart;
    Payment payment;

    Shipment shipment;
}

class Shipment {

    int shipmentId;
    String address;
    PaymentStatus paymentStatus;
    ShippingStatus shippingStatus;
}
enum ShippingStatus {
    PENDING,SHIPPED,CANCELLED,DELIVERED
}

class Customer {
    int customerId;
    String customerName;
    String email;
    String password;
    String address;
    Cart cart;
    List<Order> orderList;
    List<PaymentStrategy> paymentStrategies;


}


interface PaymentStrategy {
    boolean verifyPayment();
    void makePayment();
}

class CardPayment implements PaymentStrategy {

    String cardHolderName;
    Long cardNumber;
    int CVV;
    Date expiryDate;

    @Override
    public boolean verifyPayment() {
        return false;
    }

    @Override
    public void makePayment() {

    }
}

class UPIPayment implements PaymentStrategy {
    @Override
    public boolean verifyPayment() {
        return false;
    }

    @Override
    public void makePayment() {

    }
}

class Payment {
    PaymentStrategy paymentStrategy;
    Double amount;

    PaymentStatus paymentStatus;

    public Payment(PaymentStrategy paymentStrategy, Double amount) {
        this.paymentStrategy = paymentStrategy;
        this.amount = amount;
    }


}

enum PaymentStatus {
    SUCCESS,DECLINED,PROCESSING,REFUNDED
}



public class main {
}
