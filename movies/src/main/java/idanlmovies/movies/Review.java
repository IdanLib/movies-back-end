package idanlmovies.movies;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reviews") // telling the framework that this class represents the documents inside the
// cluster.
// similar to mongoose schema?
@Data // comes from lombok - creates getters setters for each of the instance
		// variables, as well as a toString method
@AllArgsConstructor // lombok, creates a constructor that takes all arguments as params
@NoArgsConstructor // lombok, creates a constructor that takes no arguments as params

public class Review {
	@Id // tells the framework that this is the unique identifier for each movie
	private ObjectId id;
	private String body;

	// create custom constructor that only takes the body
	public Review(String body) {
		this.body = body;
	};
};