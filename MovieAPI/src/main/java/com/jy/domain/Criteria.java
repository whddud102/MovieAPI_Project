package com.jy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {
	private int display;		// 한 번에 출력할 영화 개수
	private int currentPage;		// 현재 보고 있는 페이지 번호
	
	// 파라미터를 전달하지 않으면 기본 생성자로 생성
	// 기본생성자는 9개 출력에, 1페이지를 보고 있다고 가정
	public Criteria() {
		this(9, 1);
	}
}
