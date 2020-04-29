package com.jy.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jy.config.HttpConnectionConfig;
import com.jy.config.RootConfig;
import com.jy.domain.MovieVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HttpConnectionConfig.class, RootConfig.class})
public class MovieServiceTest {

	@Autowired
	private MovieService movieServiceImpl;
	
	@Test
	public void testExist() {
		log.info(movieServiceImpl);
	}
	
	@Test
	public void getItems_Test() {
		List<MovieVO> items = movieServiceImpl.getItems("클래식");
		
		for (MovieVO movie : items) {
			log.info(movie);
			
//			log.info(" ");
//			log.info(movie.getTitle());
//			log.info(movie.getSubtitle());
//			log.info(movie.getDirector());
//			log.info(movie.getPubDate());
//			log.info(movie.getActor());
//			log.info(movie.getLink());
//			log.info(movie.getImage());
//			log.info(movie.getUserRating());
			log.info("----------------------------");
		}
		
		
	}
	
	@Test
	public void getItemsWithDisplay_Test() {
		log.info("Display = 9로 검색 요청");
		List<MovieVO> items = movieServiceImpl.getItems("오직 그대만", 9);
		
		for (MovieVO movie : items) {
			log.info(" ");
			log.info(movie.getTitle());
			log.info(movie.getSubtitle());
			log.info(movie.getDirector());
			log.info(movie.getPubDate());
			log.info(movie.getActor());
			log.info(movie.getLink());
			log.info(movie.getImage());
			log.info(movie.getUserRating());
			log.info("----------------------------");
		}
	}
}
