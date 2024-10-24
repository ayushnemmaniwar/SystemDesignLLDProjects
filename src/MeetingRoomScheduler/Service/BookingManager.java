package MeetingRoomScheduler.Service;

import MeetingRoomScheduler.Domain.Booking;
import MeetingRoomScheduler.Domain.MeetingRoom;
import MeetingRoomScheduler.Domain.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingManager {
        List<Booking> bookingList;
        HashMap<Integer,Booking> bookingHashMap;
        public BookingManager() {
            bookingList = new ArrayList<>();
            bookingHashMap = new HashMap<>();
        }
        void addBooking() {

        }
        void showBookings() {

        }

    public void bookMeetingRoom(MeetingRoom meetingRoom, LocalDateTime startTime, LocalDateTime endTime, List<User> participantsList) {
        Booking booking = new Booking("1",meetingRoom,startTime,endTime,participantsList);
        bookingList.add(booking);
    }
}
