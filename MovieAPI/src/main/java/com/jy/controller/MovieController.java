package com.jy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jy.domain.MovieVO;
import com.jy.service.MovieService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping(value = "/search/{query}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieVO> getItems(@PathVariable("query") String query) {
		log.info("/movie/search/" + query + "  요청 됨");
		
		List<MovieVO> items = movieService.getItems(query);
		return items;
		
	}
}
