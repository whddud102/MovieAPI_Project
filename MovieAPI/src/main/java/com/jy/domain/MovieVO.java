package com.jy.domain;

import lombok.Data;

@Data
public class MovieVO {
	private String title;
	private String link;
	private String image;
	private String subtitle;
	private String pubDate;
	private String director;
	private String actor;
	private double userRating;
	
	public String getFormmatedName() {
		return getTitle().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}
}
