package idanlmovies.movies;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies") // telling the framework that this class represents the documents inside the
// cluster.
// similar to mongoose schema?
@Data // comes from lombok - creates getters setters for each of the instance
		// variables, as well as a toString method
@AllArgsConstructor // lombok, creates a constructor that takes all arguments as params
@NoArgsConstructor // lombok, creates a constructor that takes no arguments as params

public class Movie {
	@Id // tells the framework that this is the unique identifier for each movie
	private ObjectId id;
	private String imdbId;
	private String title;
	private String releaseDate;
	private String trailerLink;
	private String poster;
	private List<String> genres;
	private List<String> backdrops;

	@DocumentReference // tells the framework (SpringBoot) to tell the db to only store the REFERENCES
						// for these reviews. The reviews themselves will be stored in a separate
						// collection.
	// So, this is no longer a one-to-many relationship (embedded), but a manual
	// reference relatinoship
	private List<Review> reviewIds;
}