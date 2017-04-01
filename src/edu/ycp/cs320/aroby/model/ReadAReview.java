package edu.ycp.cs320.aroby.model;

import java.sql.Time;

public class ReadAReview {
	private String topic, reviewText, recommendation, firstName, lastName, title, author, description, reflection;
	private Double rating;
	private Time date;
	private String url;
	
	
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
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setAuthor(String author){
		this.author = author;
	}
	public void setlastName(String lastName){
		this.lastName = lastName;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public void setReflection(String reflection){
		this.reflection = reflection;
	}
	public void setURL(String url){
		this.url = url;
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
	public Double getRating(){
		return rating;
	}
	public Time getDate(){
		return date;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String getAuthor(){
		return author;
	}
	public String getTitle(){
		return title;
	}
	public String getDescription(){
		return description;
	}
	public String getReflection(){
		return reflection;
	}
	public String getURL(){
		return url;
	}
}

