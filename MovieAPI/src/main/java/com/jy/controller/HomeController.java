package com.jy.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jy.domain.API_ResponseVO;
import com.jy.domain.Criteria;
import com.jy.domain.MovieVO;
import com.jy.domain.PageDTO;
import com.jy.service.MovieService;
import com.jy.utils.MovieAPI_Util;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class HomeController {
	
	private MovieService movieService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@GetMapping("/")
	public String home() throws Exception {
		return "home";
	}
	
}
