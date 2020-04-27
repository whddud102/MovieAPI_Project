package com.jy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jy.utils.MovieAPI_Util;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class HomeController {
	
	private MovieAPI_Util movieAPI_Util;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String home(Model model) {
		log.info("restTemplate 주입 확인 : " + movieAPI_Util);
		
		return "home";
	}
	
}
