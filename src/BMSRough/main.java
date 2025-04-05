package BMSRough;

//City->CinemaHall->Screen->Show->Seat
//Booking, Payment, Notification
//User admin

import java.util.Date;
import java.util.List;

class City {
    int id;
    String cityName;
    List<CinemaHall> cinemaHallList;
}
 class CinemaHall {
    int id;
    Address address;
    List<Screen> screenList;
}

class Address {
    String locality;
    int pincode;
    String landMark;
}

class Screen {
    int id;
    List<Show> showList;
}

class Show {
    Movie movie;
    Date time;
    List<Seat> seatList;
}

class Seat {
    String row;
    int number;
}

class Movie {
    String id;
    String movieName;
    int movieDurationInMinutes;
}

class User {
    int id;
    String name;
}

class Admin {
    int id;
    String adminName;
}

class Booking {
    int bookingId;
    Show show;
    Payment payment;
}

interface PaymentStrategy {
    void verifyPayment();
    void makePayment();
}

class UPIStrategy implements PaymentStrategy {

    @Override
    public void verifyPayment() {

    }

    @Override
    public void makePayment() {

    }
}

class CardStrategy implements PaymentStrategy {
    @Override
    public void verifyPayment() {

    }

    @Override
    public void makePayment() {

    }
}

class Payment {
    int id;
    PaymentStrategy paymentStrategy;
    Double amount;

}






public class main {
}
