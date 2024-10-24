package BookMyShowLLD;

import BookMyShowLLD.Movie;
import BookMyShowLLD.Screen;

import java.util.ArrayList;
import java.util.List;

public class Show {
    String showId;
    Movie movie;
    Screen screen;
    int showDuration;
    List<Integer> bookedSeats = new ArrayList<>();

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getShowDuration() {
        return showDuration;
    }

    public void setShowDuration(int showDuration) {
        this.showDuration = showDuration;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
