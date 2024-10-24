package BookMyShowLLD;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    String screenId;
    List<Seat> seatList = new ArrayList<>();

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
