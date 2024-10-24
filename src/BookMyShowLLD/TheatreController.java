package BookMyShowLLD;

import BookMyShowLLD.City;
import BookMyShowLLD.Movie;
import BookMyShowLLD.Show;
import BookMyShowLLD.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatre;
    List<Theatre> theatreList;

    public TheatreController() {
        cityVsTheatre = new HashMap<>();
        theatreList = new ArrayList<>();
    }

    void addTheatre(Theatre theatre,City city) {
        List<Theatre> theatres = cityVsTheatre.getOrDefault(city,new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city,theatres);
    }

    Map<Theatre,List<Show>> allShows(Movie movie, City city) {
        Map<Theatre,List<Show>> theatreShowListMap = new HashMap<>();
        List<Theatre> theatres = cityVsTheatre.get(city);
        for(Theatre theatre : theatres) {
            List<Show> showList = theatre.getShowsList();
            List<Show> allShows = new ArrayList<>();
            for(Show show :showList) {
                if(show.movie.getMovieId().equalsIgnoreCase(movie.getMovieId())) {
                    allShows.add(show);
                }
            }
            theatreShowListMap.put(theatre,allShows);
        }
        return theatreShowListMap;
    }
}
