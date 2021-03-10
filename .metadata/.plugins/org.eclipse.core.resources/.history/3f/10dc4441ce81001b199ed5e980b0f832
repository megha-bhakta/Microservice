package com.demo.moviecatalogservice.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.moviecatalogservice.Model.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getcatalog(@PathVariable("userId") String userId){
		return Collections.singletonList(new CatalogItem("Test","Test Desc", 4));
		
	}
}
