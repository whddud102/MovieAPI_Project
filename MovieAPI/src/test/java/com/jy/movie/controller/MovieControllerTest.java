package com.jy.movie.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jy.config.HttpConnectionConfig;
import com.jy.config.RootConfig;
import com.jy.config.ServletConfig;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {HttpConnectionConfig.class, RootConfig.class, ServletConfig.class})
public class MovieControllerTest {
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	@Test
	public void testExist() {
		log.info("ctx : " + ctx);
		log.info("mockMvc : " + mockMvc);
	}
	
	@Test
	public void testSearch() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/movie/search/one/120"))
			);
	}

}
