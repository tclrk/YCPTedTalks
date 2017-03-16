package edu.ycp.cs320.aroby.model;

import java.sql.Time;

public class ReadAReview {
	private String topic, reviewText, recommendation;
	private double rating;
	private Time date;
	
	
	public ReadAReview() {
	}
	
	public void setTopic(String topic){
		this.topic = topic;
	}
	public void setReviewText(String reviewText){
		this.reviewText = reviewText;
	}
	public void setRecommendation(String recommendation){
		this.recommendation = recommendation;
	}
	public void setRating(Double rating){
		this.rating = rating;
	}
	public void setDate(Time date){
		this.date = date;
	}
	public String getTopic(){
		return topic;
	}
	public String getReviewText(){
		return reviewText;
	}
	public String getRecommendation(){
		return recommendation;
	}
	public double getRating(){
		return rating;
	}
	public Time getDate(){
		return date;
	}
}

