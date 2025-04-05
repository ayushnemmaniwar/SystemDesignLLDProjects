package ElevatorLLD;

import java.util.List;
import java.util.Queue;

//Elevator->floor
//Elevatorservice
class Elevator {
    int elevatorId;
    String elevatorName;
    int capacity;
    LiftStatus liftStatus;
    Floor currentFloor;
    List<Floor> floorList;
}

enum LiftStatus {
    UP,DOWN,REST,WAITING
}

class Floor {
    int floorId;
    int floorNumber;
    int elevatorId;
}

class Request {
    Floor source;
    Floor destination;
    boolean movement;//true(up) and false(down)

}

class ElevatorService {
    Queue<Request> requestQueue;
}
public class main {
}
