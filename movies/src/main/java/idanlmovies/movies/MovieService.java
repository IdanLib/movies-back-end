package idanlmovies.movies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//This is a service
@Service

// it interacts with the repository (ie database)
@Repository
public class MovieService {

    @Autowired // tells Spring to initialize the movieRepository variable for us
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    };

    // Optional - tells Java that the return value might (but not necessarily) be
    // null.
    // (because Id might not exist and search will fail)
    public Optional<Movie> getSingleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    };
}