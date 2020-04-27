package com.jy.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jy.domain.API_ResponseVO;
import com.jy.domain.MovieVO;
import com.jy.utils.MovieAPI_Util;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

	private MovieAPI_Util movieAPI_Util;
	
	@Override
	public List<MovieVO> getItems(String query) {
		movieAPI_Util.setQuery(query);
		ResponseEntity<API_ResponseVO> response = null;
		
		try {
			response = movieAPI_Util.request();
		} catch (Exception e) {
			log.warn("MovieServiceImpl - getItems() 에러 : " + e.getMessage());
		}
		
		API_ResponseVO api_ResponseVO = response.getBody();
		List<MovieVO> items =  api_ResponseVO.getItems();
		
		return items;
	}

}
