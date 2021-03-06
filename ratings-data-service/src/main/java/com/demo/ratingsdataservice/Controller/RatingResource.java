package com.demo.ratingsdataservice.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ratingsdataservice.Model.Rating;
import com.demo.ratingsdataservice.Model.UserRatings;

@RestController
@RequestMapping("/ratings")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId){
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("/user/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId) {
		 List<Rating> rating = Arrays.asList(
	                new Rating("1234", 3),
	                new Rating("5678", 4)
	        );
        UserRatings userRating = new UserRatings();
        userRating.setRating(rating);
        return userRating;

}
}
