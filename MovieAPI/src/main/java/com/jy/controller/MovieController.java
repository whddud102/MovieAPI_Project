package com.jy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jy.domain.API_ResponseVO;
import com.jy.domain.Criteria;
import com.jy.domain.PageDTO;
import com.jy.service.MovieService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	/**
	 * 영화 검색을 요청 받고 검색 결과와 페이지 정보를 담은 pageDTO 객체를 json으로 반환
	 * @param query	검색어
	 * @param currentPage 현재보고 있는 페이지
	 * @param display 한 번에 출력할 영화 개수	
	 * @return 검색 결과와 페이지 정보를 담은 pageDTO 객체를 json으로 반환
	 */
	@GetMapping(value = "/search/{query}/{currentPage}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageDTO getItems(@PathVariable("query") String query,
			@PathVariable("currentPage") int currentPage) {
		
		log.info("/movie/search/" + query + "/" + currentPage + " 요청 됨");
		
		API_ResponseVO api_ResponseVO = movieService.getResponse(query, 9, currentPage);
		Criteria cri = new Criteria(currentPage);
		
		PageDTO pageDTO = new PageDTO(cri, api_ResponseVO);
		
		log.info("응답 pageDTO : " + pageDTO);
		
		return  pageDTO;
		
	}
}
