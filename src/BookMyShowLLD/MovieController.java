package BookMyShowLLD;

import BookMyShowLLD.City;
import BookMyShowLLD.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityVsMovie;
    List<Movie> movieList;

    public MovieController() {
        cityVsMovie = new HashMap<>();
        movieList = new ArrayList<>();
    }

    void addMovie(City city,Movie movie) {
        movieList.add(movie);
        List<Movie> movies = cityVsMovie.getOrDefault(city,new ArrayList<>());
        movies.add(movie);
        cityVsMovie.put(city,movies);
    }

    Movie getMovieByName(String movieName) {
        for(Movie movie : movieList) {
            if(movie.getMovieName().equalsIgnoreCase(movieName)) {
                return movie;
            }
        }
        return null;
    }

    List<Movie> getMovieByCity(String city) {
        return cityVsMovie.get(city);
    }
}
