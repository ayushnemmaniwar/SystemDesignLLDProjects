package FlightBooking;
//
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//class Airport {
//
//}
//
//class FlightInfo {
//    String flightId;
//    String flightName;
//    Long capacity;
//
//    List<Seat> seat;
//}
//
//class Seat {
//
//}
//class Flight {
//    FlightInfo flightInfo;
//
//    Airport airport;
//
//    String flightNumber;
//    String src;
//    String dest;
//
//    String date;
//
//    double price;
//
//    Date departureTime;
//    Date arrivalTime;
//}
//
//class FlightManager {
//    List<Flight>flightList;
//
//    public FlightManager() {
//        flightList = new ArrayList<>();
//    }
//
//    void addFlight(Flight flight) {
//        flightList.add(flight);
//    }
//
//    List<Flight> searchFlight(String src, String dest, Date date) {
//
//        List<Flight> flight = new ArrayList<>();
//        return flight;
//    }
//
//    void showAllAvailableAirlines(List<Flight> flights) {
//
//    }
//
//}
//
//class Person implements Observer {
//    String personId;
//    String name;
//    String email;
//    String password;
//    List<Booking> bookingList;
//    @Override
//    public void update() {
//
//    }
//
//}
//
//class Booking {
//    String bookingId;
//    Person person;
//    Flight flight;
//    Transaction transaction;
//}
//
//class Transaction {
//    String transactionId;
//    Booking booking;
//    double amount;
//}
//
//interface Observer {
//    void update();
//}
//
//
//interface NotificationService {
//    void subscribe();
//    void unSubscribe();
//    void update();
//}
//
//class BookingNotification implements NotificationService {
//
//    List<Observer>observerList;
//
//    public BookingNotification() {
//        this.observerList = new ArrayList<>();
//    }
//
//    @Override
//    public void subscribe() {
//
//    }
//
//    @Override
//    public void unSubscribe() {
//
//    }
//
//    @Override
//    public void update() {
//
//    }
//}

//Airport -> FlightInfo -> Seat -> ScheduleFlight -> ScheduleSeat
//Person
//Booking -> CustomerInfo
//Notification
//Payment






import java.util.Date;
import java.util.List;

class Airport {
    String airportId;
    String city;
    String airportName;
    Address address;
}
class Address {
    String pincode;
    String location;
}

class FlightInfo {
    String flightId;
    String flightName;
    int capacity;
    List<Seat> seatList;
}

class Seat {
    int seatNo;
    SeatType seatType;
}

enum SeatType {
    ECONOMY,BUSINESS
}

class ScheduleFlight{
    FlightInfo flightInfo;
    String flightNumber;
    Airport source;
    Airport destination;

    Date date;
    Date departureTime;
    Date arrivalTime;
    List<ScheduleSeat> scheduleSeatList;
}

class ScheduleSeat extends Seat {
    Double price;

    //Booking status
}

class Person implements Observer{
    String personId;
    String personName;
    String email;
    String passWord;

    @Override
    public void update() {

    }
}

class Booking {
    String bookingId;
    ScheduleFlight scheduleFlight;
    Transaction transaction;

    Long Amount;
    Person person;
    List<CustomerDetails> customerDetailsList;
}

class CustomerDetails {
    Person person;
    int age;
    ScheduleSeat scheduleSeat;
    Gender gender;
}

enum Gender {
    MALE,FEMALE,OTHER;
}

class Transaction {
    String transactionId;
    Payment payment;
    Double Amount;
}

interface PaymentStrategy {
    boolean verifyPaymentDetails();
    void makePayment();
}
class CardPayment implements PaymentStrategy {

    Long cardNumber;
    String cardHolderName;
    int CVV;

    @Override
    public boolean verifyPaymentDetails() {
        return true;
    }

    @Override
    public void makePayment() {

    }
}

class UPIPayment implements PaymentStrategy {

    Long phoneNumber;
    String bankName;

    @Override
    public boolean verifyPaymentDetails() {
        return true;
    }

    @Override
    public void makePayment() {

    }
}

class Payment {
    String paymentId;
    PaymentStrategy paymentStrategy;
    Double amount;

    public Payment(PaymentStrategy paymentStrategy,Double amount) {
        this.paymentStrategy = paymentStrategy;
        this.amount=amount;
    }

    void processPayment() {
        if(paymentStrategy.verifyPaymentDetails()) {
            paymentStrategy.makePayment();
        }
    }


}

interface Observer {
    void update();
}

interface NotificationService {
    void subscribe();
    void unSubscribe();
    void update();
}

class EmailNotification implements NotificationService {

    List<Observer> observerList;
    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void update() {

    }
}
class SMSNotification implements NotificationService {

    List<Observer> observerList;
    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void update() {

    }
}






public class main {
}
