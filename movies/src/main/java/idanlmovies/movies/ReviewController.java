package idanlmovies.movies;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//a controller to route requests 
//Its only task is to get a post request to insert a review
@RestController

@RequestMapping("/api/v1/reviews") // one endpoint

public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
		// Review rev = reviewService.createReview(body, imdbId);
		return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),
				HttpStatus.CREATED);
	}
};