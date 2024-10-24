package BookMyShowLLD;

import BookMyShowLLD.City;
import BookMyShowLLD.Screen;
import BookMyShowLLD.Show;

import java.util.List;

public class Theatre {
    String theatreId;
    String theatreName;
    String theatreAddress;
    List<Screen> screenList;
    List<Show> showsList;
    City city;

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreAddress() {
        return theatreAddress;
    }

    public void setTheatreAddress(String theatreAddress) {
        this.theatreAddress = theatreAddress;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public List<Show> getShowsList() {
        return showsList;
    }

    public void setShowsList(List<Show> showsList) {
        this.showsList = showsList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
