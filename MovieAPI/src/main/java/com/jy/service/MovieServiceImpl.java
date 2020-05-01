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
	public API_ResponseVO getResponse(String query) {
		movieAPI_Util.setQuery(query);
		ResponseEntity<API_ResponseVO> response = null;
		
		try {
			response = movieAPI_Util.request();
		} catch (Exception e) {
			log.warn("MovieServiceImpl - getItems() 에러 : " + e.getMessage());
		}
		
		return response.getBody();
	}

	@Override
	public API_ResponseVO getResponse(String query, int display) {
		movieAPI_Util.setDisplay(display);
		
		return getResponse(query);
	}

	@Override
	public API_ResponseVO getResponse(String query, int display, int currentPage) {
		// 영화를 9 개씩 검색할 경우, 전달 받은 현재 페이지에 해당하는 영화들의 시작 번호
		// start 번호 부터 9개의 영화를 검색
		int start = (9*(currentPage -1) + 1);	
		
		// api의 요청 한계로 start 값은 최대 값이 1000임
		if(start > 1000) {
			start = 1000;
		}
			
		
		movieAPI_Util.setStart(start);

		return getResponse(query, display);
	}
	
	@Override
	public List<MovieVO> getItems(String query) { 
		return getResponse(query).getItems();
	}

	@Override
	public List<MovieVO> getItems(String query, int display) {
		return getResponse(query, display).getItems();
	}

	@Override
	public List<MovieVO> getItems(String query, int display, int page) {
		return getResponse(query, display, page).getItems();
	}

}
