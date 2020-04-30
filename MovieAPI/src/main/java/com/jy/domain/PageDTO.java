package com.jy.domain;

import lombok.Data;
import lombok.extern.log4j.Log4j;

/**
 * 페이징 처리를 위한 정보를 담는 클래스
 */
@Data
@Log4j
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total; 		// 검색된 전체 영화 개수
	private Criteria cri;	// 검색 조건을 담고 있는 객체
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
	
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getDisplay())) ;
		
		log.info("realEnd : " + realEnd);
		
		if(realEnd < endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		log.info("PageDTO 객체 생성 완료 : " + this);
	}
}
