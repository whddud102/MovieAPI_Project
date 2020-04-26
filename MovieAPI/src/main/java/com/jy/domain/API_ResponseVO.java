package com.jy.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class API_ResponseVO {
	private Integer total;
	private Integer start;
	private Integer display;
	private List<MovieVO> items;
}
