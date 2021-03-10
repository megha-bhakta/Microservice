package com.demo.moviecatalogservice.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.moviecatalogservice.Model.CatalogItem;
import com.demo.moviecatalogservice.Model.Movie;
import com.demo.moviecatalogservice.Model.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	
	@Autowired
	public RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getcatalog(@PathVariable("userId") String userId){
		
		List<Rating> ratingList = Arrays.asList(
				 new Rating("1234", 3),
	             new Rating("5678", 4)
	    );
		
		return ratingList.stream()
				.map(rating -> {
                    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "Description", rating.getRating());
                })
                .collect(Collectors.toList());	
	}
}
