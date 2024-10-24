package MeetingRoomScheduler.Domain;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class MeetingRoom {
    String roomId;
    int capacity;
    private TreeMap<LocalDateTime, LocalDateTime> calendar;

    public MeetingRoom(String roomId, int capacity) {
        this.roomId = roomId;
        this.capacity = capacity;
        calendar = new TreeMap<>();
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public TreeMap<LocalDateTime, LocalDateTime> getCalendar() {
        return calendar;
    }

    public void setCalendar(TreeMap<LocalDateTime, LocalDateTime> calendar) {
        this.calendar = calendar;
    }
}
