package com.jy.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class API_ResponseVO {
	private int total;
	private int start;
	private int display;
	private List<MovieVO> items;
}
