package idanlmovies.movies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service

@Repository
public class MovieService {

    @Autowired 
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    };

    public Optional<Movie> getSingleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    };
}