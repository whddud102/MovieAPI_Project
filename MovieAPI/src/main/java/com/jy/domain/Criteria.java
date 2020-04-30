package com.jy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {
	private int display;
	private int pageNum;		// 현재 보고 있는 페이지 번호
	
	// 기본생성자는 9개 출력에, 1페이지를 보고 있다고 가정
	public Criteria() {
		this(9, 1);
	}
}
