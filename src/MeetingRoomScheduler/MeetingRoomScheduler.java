package MeetingRoomScheduler;

import MeetingRoomScheduler.Domain.MeetingRoom;
import MeetingRoomScheduler.Domain.User;
import MeetingRoomScheduler.Service.BookingManager;
import MeetingRoomScheduler.Service.MeetingRoomManager;
import MeetingRoomScheduler.Service.UserManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoomScheduler {
    UserManager userManager;
    MeetingRoomManager meetingRoomManager;
    BookingManager bookingManager;
    public MeetingRoomScheduler() {
        userManager = new UserManager();
        meetingRoomManager = new MeetingRoomManager();
        bookingManager = new BookingManager();
    }

    public void initialize() {
        System.out.println("Meeting Room Data Initialization");
        User user1 = new User("1","ayush","ayushnemmaniwar12@gmail.com");
        User user2 = new User("2","Anurag","anurag12@gmail.com");
        User user3 = new User("3","Yash","Yash@gmail.com");
        userManager.addUser(user1);
        userManager.addUser(user2);
        userManager.addUser(user3);
        MeetingRoom meetingRoom1 = new MeetingRoom("1",4);
        MeetingRoom meetingRoom2 = new MeetingRoom("2",5);
        MeetingRoom meetingRoom3 = new MeetingRoom("3",5);
        meetingRoomManager.addRoom(meetingRoom1);
        meetingRoomManager.addRoom(meetingRoom2);
        meetingRoomManager.addRoom(meetingRoom3);

        LocalDateTime startTime = LocalDateTime.of(2024,10,23,10,0);
        LocalDateTime endTime = LocalDateTime.of(2024,10,23,11,0);
        List<User> participantsList = Arrays.asList(user1,user2);
        scheduleBook(startTime,endTime,5,participantsList);

    }

    private void scheduleBook(LocalDateTime startTime, LocalDateTime endTime, int capacity, List<User> participantsList) {
        boolean isAllParticipantsAvailable = userManager.isAllParticipantsAvailable(startTime,endTime);
        if(!isAllParticipantsAvailable) {
            System.out.println("All Participants are not please choose different start and end times");
            return;
        }
        List<MeetingRoom> availableRooms = meetingRoomManager.getEmptyMeetingRooms(startTime,endTime,capacity);
        if(availableRooms.size()==0) {
            System.out.println("No Rooms are available please select different time slots");
            return;
        }
        MeetingRoom meetingRoom = availableRooms.get(0);
        meetingRoomManager.blockMeeting(meetingRoom,startTime,endTime);
        bookingManager.bookMeetingRoom(meetingRoom,startTime,endTime,participantsList);
    }
}
