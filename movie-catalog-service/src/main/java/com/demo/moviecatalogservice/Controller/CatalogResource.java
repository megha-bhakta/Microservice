package com.demo.moviecatalogservice.Controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.moviecatalogservice.Model.CatalogItem;
import com.demo.moviecatalogservice.Model.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getcatalog(@PathVariable("userId") String userId){
		
		List<Rating> rating = Arrays.asList(
				 new Rating("1234", 3),
	             new Rating("5678", 4)
	    );
		
		return rating.stream()
				.map(ratings ->  new CatalogItem("Name", "Desc", ratings.getRating()))
                .collect(Collectors.toList());	
	}
}
