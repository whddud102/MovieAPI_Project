package com.jy.domain;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jy.config.HttpConnectionConfig;
import com.jy.utils.MovieAPI_Util;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HttpConnectionConfig.class})
public class MovieVOTests {
	
	@Autowired
	private MovieAPI_Util movieAPI_Util;
	
	
	@Test
	public void getFormmatedName_Test() throws Exception {
		movieAPI_Util.setQuery("나무");
		ResponseEntity<API_ResponseVO> response = movieAPI_Util.request();
		API_ResponseVO api_ResponseVO = response.getBody();
		
		List<MovieVO> items =  api_ResponseVO.getItems();
		
		for(MovieVO movie : items) {
			log.info(movie.getFormmatedName());
		}
		
	}
	
	@Test
	public void movieVO_Test() throws Exception {
		movieAPI_Util.setQuery("토스트");
		ResponseEntity<API_ResponseVO> response = movieAPI_Util.request();
		API_ResponseVO api_ResponseVO = response.getBody();
		
		List<MovieVO> items =  api_ResponseVO.getItems();
		
		for(MovieVO movie : items) {
			log.info("Name : " + movie.getFormmatedName());
			log.info("Actor : " + movie.getActor());
			log.info("Director : " + movie.getDirector());
			log.info("Image : " + movie.getImage());
			log.info("PubDate : " + movie.getPubDate());
			log.info("SubTitle : " + movie.getSubtitle());
			log.info("UserRating : " + movie.getUserRating());
			log.info("---------------------------------------------------\n");
		}
		
	}
}
