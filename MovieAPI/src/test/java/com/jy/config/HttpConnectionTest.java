package com.jy.config;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jy.domain.API_ResponseVO;
import com.jy.domain.MovieVO;
import com.jy.utils.MovieAPI_Util;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HttpConnectionConfig.class, RootConfig.class})
public class HttpConnectionTest {

	@Autowired
	private MovieAPI_Util movieAPI_Util;

	@Test
	public void testExist() {
		assertNotNull(movieAPI_Util);
		log.info("MovieAPI_Util 객체의 의존성 주입 테스트 : " + movieAPI_Util);
	}

	@Test
	public void testRequest() {
		try {
			movieAPI_Util.setQuery("여행");
			movieAPI_Util.setStart(1);
			movieAPI_Util.setDisplay(2);
			
			ResponseEntity<API_ResponseVO> response = movieAPI_Util.request();
			API_ResponseVO api_ResponseVO = response.getBody();
			List<MovieVO> items = api_ResponseVO.getItems();

			log.info("-------- API 요청 결과(query : " + movieAPI_Util.getQuery() + ") -------");
			log.info("display : " + api_ResponseVO.getDisplay());
			log.info("total : " + api_ResponseVO.getTotal());

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
				log.info(" ");
			}
		} catch (Exception e) {
			e.getMessage();
		}

		/*
		 * try { movieAPI_Util.setQuery("top"); movieAPI_Util.setStart(3);
		 * ResponseEntity<String> response = movieAPI_Util.request();
		 * 
		 * log.info(response.getBody()); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 * 
		 */
	}

}
