package com.jy.config;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jy.utils.MovieAPI_Util;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HttpConnectionConfig.class })
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
		String response =  movieAPI_Util.requestAPI_By_Query("테스트");
		log.info(response);
	}
	
}
