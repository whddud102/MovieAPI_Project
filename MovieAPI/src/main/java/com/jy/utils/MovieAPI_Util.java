package com.jy.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class MovieAPI_Util {
	
	final String CLIENT_ID = "cZsMzsNXZCUKChilq1dL";
	final String CLIENT_SECRET = "wifLQHSKps";
	final String REQUEST_URL = "https://openapi.naver.com/v1/search/movie.json";
	final private RestTemplate restTemplate;
	
	@Autowired
	public MovieAPI_Util(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public String requestAPI_By_Query(String query) {
		final HttpHeaders headers = new HttpHeaders();

		headers.set("X-Naver-Client-Id", CLIENT_ID);
		headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

		final HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<String> response = restTemplate.exchange(
				REQUEST_URL + "?query=" + query, HttpMethod.GET, entity, String.class);
		
		return response.getBody();
	}
}
