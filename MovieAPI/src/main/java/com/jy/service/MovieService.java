package com.jy.service;

import java.util.List;

import com.jy.domain.API_ResponseVO;
import com.jy.domain.MovieVO;

public interface MovieService {
	
	public List<MovieVO> getItems(String query);
	
	public List<MovieVO> getItems(String query, int display);
	
	public List<MovieVO> getItems(String query, int display, int page);
	
	public API_ResponseVO getResponse(String query);
	
	public API_ResponseVO getResponse(String query, int display);
	
	public API_ResponseVO getResponse(String query, int display, int page);
}
