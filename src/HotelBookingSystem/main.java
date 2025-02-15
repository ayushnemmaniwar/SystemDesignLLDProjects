package HotelBookingSystem;

//User (Login,Registration) -> Search (Hotel) -> Choose Room (Number of rooms) -> Booking -> Payment -> Notification


import java.util.Date;
import java.util.List;

class User implements Observer {
    int userId;
    String userName;
    String email;
    String password;
    Long phoneNumber;
    int age;

    @Override
    public void sendUpdate() {

    }
}

class Hotel implements Observer {
    int hotelId;
    String hotelName;
    HotelType hotelType;
    String city;
    String address;
    List<Room> roomList;

    @Override
    public void sendUpdate() {

    }
}

enum HotelType {
    Star3,Star5,Star7
}

class Room {
    int roomId;
    Hotel hotel;
    int roomNumber;
    int capacity;
    List<Booking> bookingList;
}

class Booking {
    int bookingId;
    User user;
    Hotel hotel;
    Payment payment;
    List<RoomBooking> roomList;
}
class RoomBooking {
    int roomBookingId;
    Room room;
    Date date;
    Date checkIn;
    Date checkOut;
    List<Guest> userList;
}

class Guest {
    int guestId;
    String name;
    Long phoneNumber;
    int age;
    Gender gender;
}
enum Gender {
    MALE,FEMALE,OTHER
}

interface PaymentStrategy {
    boolean verifyPayment();
    void makePayment();
}

class CardPayment implements PaymentStrategy {

    String cardHolderName;
    Long accountNumber;
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
    Long phoneNumber;

    @Override
    public boolean verifyPayment() {
        return false;
    }

    @Override
    public void makePayment() {

    }
}
class Payment {
    Double amount;
    PaymentStrategy paymentStrategy;

    PaymentStatus paymentStatus;

    public Payment(Double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }
}

enum PaymentStatus {
    Success,Failed,Processing,Refunded
}

interface Observer {
    void sendUpdate();
}

interface NotificationService {
    void subscribe();
    void unsubscribe();
    void sendUpdate();
}

class EmailNotification implements NotificationService {

    List<Observer> observerList;

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void sendUpdate() {

    }
}
class SMSNotification implements NotificationService {
    List<Observer> observerList;

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void sendUpdate() {

    }
}

public class main {
}
