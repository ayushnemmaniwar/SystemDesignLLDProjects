package ParkingLot;
//ParkingSpace->Floors->Spot
//User->Vehicle

import java.util.Date;
import java.util.List;

class ParkingSpace {
    int parkingSpaceId;
    String parkingName;
    String address;
    List<Floor> floorList;
}
class Floor {
    int floorId;
    int floorNumber;
    ParkingSpace parkingSpace;
    List<Spot> spotList;
}

class Spot {
    int spotId;
    VehicleType vehicleType;
    Floor floor;
    boolean isAvailable;
}
enum VehicleType {
    TWO_WHEELER,THREE_WHEELER,FOUR_WHEELER
}

class User {
    int userId;
    String userName;
    String email;
    Long phone;
    String password;
    List<Vehicle> vehicleList;
}
class Vehicle {
    int vehicleId;
    String vehicleName;
    String vehicleNumber;
    VehicleType vehicleType;
}

class Booking {
    int bookingId;
    ParkingSpace parkingSpace;
    User user;
    Vehicle vehicle;
    Date startTime;
    Date endTime;
    int amount;
}
public class main {

}
