package MeetingRoomScheduler.Service;

import MeetingRoomScheduler.Domain.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class UserManager {
    List<User> userList;
    HashMap<String ,User> userHashMap;

    public UserManager() {
        userList = new ArrayList<>();
        userHashMap = new HashMap<>();
    }
    public void addUser(User user) {
        userList.add(user);
        userHashMap.put(user.getId(),user);
    }
    boolean isAvialable() {
        return true;
    }

    public boolean isAllParticipantsAvailable(LocalDateTime startTime, LocalDateTime endTime) {
        for(User user : userList) {
            TreeMap<LocalDateTime, LocalDateTime> calendar = user.getCalendar();
            for(LocalDateTime existingStart : calendar.keySet()) {
                LocalDateTime existingEnd = calendar.get(existingStart);
                if(startTime.isBefore(existingEnd) && endTime.isAfter(existingStart)) {
                    return false;
                }
            }
        }
        return true;
    }
}
