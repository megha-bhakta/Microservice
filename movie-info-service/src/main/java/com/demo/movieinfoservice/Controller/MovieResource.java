package com.demo.movieinfoservice.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.movieinfoservice.Model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@RequestMapping("/{movieId}")
	public Movie getMovies(@PathVariable("movieId") String movieId) {
		 return new Movie(movieId, "Name for ID " + movieId);
	}

}
