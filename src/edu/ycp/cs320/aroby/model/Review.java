package edu.ycp.cs320.aroby.model;

import java.sql.Time;

public class Review {
	private String name, author, topic, review, descript, link, recommendation;
	private double rating;
	private Time date;
	
	public void setReview(String name, String author, String topic, String descript, String review, String link, String recommendation, double rating) {
		this.topic = topic;
		this.review = review;
		this.descript = descript;
		this.name = name;
		this.author = author;
		this.link = link;
		this.rating = rating;
	}
	
	public String getAuthor(){
		return author;
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
	
	public Time getDate(){
		return date;
	}
	
	public String getRecommendation(){
		return recommendation;
	}
	
	public double getRating(){
		return rating;
	}
}