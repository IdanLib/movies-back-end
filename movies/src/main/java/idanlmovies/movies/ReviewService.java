package idanlmovies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//This is a service
@Service

// it interacts with the repository (ie database)
@Repository
public class ReviewService {

    @Autowired // tells Spring to initialize the movieRepository variable for us
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // Optional - tells Java that the return value might (but not necessarily) be
    // null.
    public Review createReview(String reviewBody, String imdbId) {

        // then create a review instance,
        // insert it to the review repository
        Review review = reviewRepository.insert(new Review(reviewBody));

        // associate with a particular movie -
        // update movie
        mongoTemplate.update(Movie.class)
                // whose "imdbId" criterion matches that of the arg
                .matching(Criteria.where("imdbId").is(imdbId))
                // then, use apply method to create a new update, push it to the reviewIds array
                // and the value of that new array item is the review
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    };

    // (because Id might not exist and search will fail)
}