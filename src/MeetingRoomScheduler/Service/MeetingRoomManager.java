package MeetingRoomScheduler.Service;

import MeetingRoomScheduler.Domain.MeetingRoom;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class MeetingRoomManager {
    List<MeetingRoom> meetingRoomList;
    HashMap<String,MeetingRoom> roomHashMap;
    public MeetingRoomManager() {
        meetingRoomList = new ArrayList<>();
        roomHashMap = new HashMap<>();
    }
    public void addRoom(MeetingRoom meetingRoom) {
        meetingRoomList.add(meetingRoom);
        roomHashMap.put(meetingRoom.getRoomId(),meetingRoom);
    }
    public boolean isAvailable() {

        return true;
    }

    public List<MeetingRoom> getEmptyMeetingRooms(LocalDateTime startTime, LocalDateTime endTime, int capacity) {
        List<MeetingRoom> availableRooms = new ArrayList<>();
        for(MeetingRoom meetingRoom : meetingRoomList) {
            int flag = 0;
            if(meetingRoom.getCapacity()>=capacity) {
                TreeMap<LocalDateTime, LocalDateTime> calendar = meetingRoom.getCalendar();
                for(LocalDateTime existingStart : calendar.keySet()) {
                    LocalDateTime existingEnd = calendar.get(existingStart);
                    if(startTime.isBefore(existingEnd) && endTime.isAfter(existingStart)) {
                        flag=1;
                        break;
                    }
                }
            } else {
                flag =1;
            }
            if(flag==0) {
                availableRooms.add(meetingRoom);
            }
        }
        return availableRooms;
    }

    public void blockMeeting(MeetingRoom meetingRoom, LocalDateTime startTime, LocalDateTime endTime) {
        for(MeetingRoom room:meetingRoomList) {
            if(room.getRoomId().equalsIgnoreCase(meetingRoom.getRoomId())) {
                TreeMap<LocalDateTime, LocalDateTime> calendar = room.getCalendar();
                calendar.put(startTime,endTime);
                room.setCalendar(calendar);
                return;
            }
        }
    }
}
