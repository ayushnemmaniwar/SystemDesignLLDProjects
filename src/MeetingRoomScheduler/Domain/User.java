package MeetingRoomScheduler.Domain;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class User {
    String id;
    String name;
    String email;
    private TreeMap<LocalDateTime, LocalDateTime> calendar;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        calendar = new TreeMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TreeMap<LocalDateTime, LocalDateTime> getCalendar() {
        return calendar;
    }

    public void setCalendar(TreeMap<LocalDateTime, LocalDateTime> calendar) {
        this.calendar = calendar;
    }
}
