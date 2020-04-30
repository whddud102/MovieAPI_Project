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
	private int total;
	
	private Criteria cri;	// 검색 조건을 담고 있는 객체
	private API_ResponseVO api_ResponseVO; // api 요청 결과를 담고 있는 객체
	
	public PageDTO(Criteria cri, API_ResponseVO api_ResponseVO) {
		this.cri = cri;
		this.api_ResponseVO = api_ResponseVO;
		
		this.total = api_ResponseVO.getTotal();
	
		this.endPage = (int)(Math.ceil(cri.getCurrentPage() / 10.0)) * 10;
		
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / 9)) ;
		
		if(realEnd < endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
