package com.demo.moviecatalogservice.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.moviecatalogservice.Model.CatalogItem;
import com.demo.moviecatalogservice.Model.Movie;
import com.demo.moviecatalogservice.Model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	
	@Autowired
	public RestTemplate restTemplate;

	@RequestMapping(value="/{userId}")
	public List<CatalogItem> getcatalog(@PathVariable("userId") String userId){
		
		UserRatings ratings= restTemplate.getForObject("http://ratings-data-service/rating/user", UserRatings.class);
		
		return ratings.getRating().stream()
				.map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "Description", rating.getRating());
                })
                .collect(Collectors.toList());	
	}
}
