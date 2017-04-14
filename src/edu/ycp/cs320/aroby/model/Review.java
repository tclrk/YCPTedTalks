package edu.ycp.cs320.aroby.model;

import java.net.URL;
import java.time.ZonedDateTime;

public class Review {
	private String name, author, title, topic, link, review, descript, recommendation;
	private int rating;
	private ZonedDateTime date;
	
	public void setReview(String name, String author, String title, String topic, String descript, String review, String link, String recommendation, int rating) {
		this.topic = topic;
		this.title = title;
		this.review = review;
		this.descript = descript;
		this.name = name;
		this.author = author;
		this.link = link;
		this.rating = rating;
	}
	
	public void setTime (ZonedDateTime date){
		date = ZonedDateTime.now();
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getName(){
		return name;
	}
	
	public String getReview(){
		return review;
	}
	
	public String getTopic(){
		return topic;
	}
	
	public String getDescription(){
		return descript;
	}
	
	public String getLink(){
		return link;
	}
	
	public String getRecommendation(){
		return recommendation;
	}
	
	public int getRating(){
		return rating;
	}
	
	public ZonedDateTime getDate(){
		return date;
	}
}