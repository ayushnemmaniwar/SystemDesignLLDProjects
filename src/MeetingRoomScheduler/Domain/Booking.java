package MeetingRoomScheduler.Domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Booking {
    String bookingId;
    MeetingRoom meetingRoom;
    LocalDateTime start;
    LocalDateTime end;
    List<User>participants;

    public Booking(String bookingId, MeetingRoom meetingRoom, LocalDateTime start, LocalDateTime end, List<User> participants) {
        this.bookingId = bookingId;
        this.meetingRoom = meetingRoom;
        this.start = start;
        this.end = end;
        this.participants = participants;
    }

}
