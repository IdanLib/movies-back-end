package idanlmovies.movies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//a controller to route requests 
//Its only task is to get a client request (ie browser) and send a response
@RestController

@RequestMapping("/api/v1/movies") // one endpoint
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping // a get method
	// Calls upon the Service component to provide the content
	public ResponseEntity<List<Movie>> allMovies() {
		return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
	};

	// Calls upon the Service component to provide the content
	@GetMapping("/{imdbId}") // search a movie by its id
	// @pathvariable tells the framework that this arg is provided from what's
	// inside the curly braces in the @getMapping annotation
	public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
		return new ResponseEntity<Optional<Movie>>(movieService.getSingleMovie(imdbId), HttpStatus.OK);
	};
};