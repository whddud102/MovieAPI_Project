package com.jy.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jy.domain.API_ResponseVO;

import lombok.Getter;
import lombok.Setter;


@Component
@Setter
@Getter
public class MovieAPI_Util { 
	
	final String CLIENT_ID = "cZsMzsNXZCUKChilq1dL";
	final String CLIENT_SECRET = "wifLQHSKps";
	final String REQUEST_URL = "https://openapi.naver.com/v1/search/movie.json";
	final private RestTemplate restTemplate;
	
	private String query = null;
	private Integer display = 10;
	private Integer start = 1;
	private String genre;
	
	@Autowired
	public MovieAPI_Util(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public ResponseEntity<API_ResponseVO> request() throws Exception{
		if(query == null) {
			throw new Exception("request() : setQuery()를 이용해 Query를 먼저 지정해주세요");
		}
		
		final HttpHeaders headers = new HttpHeaders();
		
		headers.set("X-Naver-Client-Id", CLIENT_ID);
		headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

		final HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange(
				REQUEST_URL + "?query=" + query + "&start=" + start + "&display=" + display, HttpMethod.GET, entity, API_ResponseVO.class);
	}
}
