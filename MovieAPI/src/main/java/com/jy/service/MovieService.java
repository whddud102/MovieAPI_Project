package com.jy.service;

import java.util.List;

import com.jy.domain.MovieVO;

public interface MovieService {
	
	public List<MovieVO> getItems(String query);
}
