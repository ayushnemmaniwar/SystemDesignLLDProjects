package FoodDelivery;
//User->search for food/restaurant -> Restaurant -> Food -> Order -> orderItem -> Payment -> Notification
//Agent -> Delivery Details -> Enums

import java.util.Date;
import java.util.List;

class Restaurant implements Observer {
    int id;
    String name;
    List<Food> foodList;
    List<Order> orderList;
    Address address;

}
class Address {
    String city;
    String location;
    Double latitude;
    Double longitude;
}

class Food {
    int id;
    String name;
    String description;
    String ingredients;
    boolean isAvailable;
    int price;
}

class User implements Observer {
    int id;
    String name;
    String email;
    String password;
    Cart cart;
    List<Address> deliveryAddressList;
    List<OrderItem> orderItemList;
}

class Agent implements Observer {
    int id;
    String name;
    String vehicleNumber;
    Order order;
    User user;
    Address address;
}
class Cart {
    int id;
    int amount;
    List<OrderItem> orderItemList;
}
class Order {
    int id;
    List<OrderItem> orderItemList;
    Payment payment;
    Agent agent;
    OrderStatus orderStatus;
    Date orderTime;
    Date estimatedDeliveryTime;
}
enum OrderStatus {
    Preparing,Delivering,Delivered,Cancelled,Refunded
}

class OrderItem {
    int id;
    Food food;
    Restaurant restaurant;
    int quantity;
    int price;
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
    String name;
    Long number;

    @Override
    public boolean verifyPayment() {
        return false;
    }

    @Override
    public void makePayment() {

    }
}

class Payment {
    int id;
    PaymentStatus paymentStatus;
    int amount;
    PaymentStrategy paymentStrategy;

    public Payment(int id, int amount, PaymentStrategy paymentStrategy) {
        this.id = id;
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }
}

enum PaymentStatus {
    InProgress,Success,Failed,Refunded,Cancelled
}

interface Observer {

}

interface Notification {
    void subscribe();
    void unsubscribe();
    void update();
}

class SMSNotification implements Notification {
    List<Observer> observerList;
    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void update() {

    }
}

class EmailNotification implements Notification {
    List<Observer> observerList;
    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void update() {

    }
}

class NotificationService {
    Notification notification;
}

public class main {
}
