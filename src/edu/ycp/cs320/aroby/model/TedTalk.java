package edu.ycp.cs320.aroby.model;

import java.net.URL;
import java.util.ArrayList;

public class TedTalk {
	private URL link;
	private String title, speaker, topic, description;
	private ArrayList<Review> review = new ArrayList<Review>();
	
	public void setTedTalk(ArrayList<Review> review, String title, String speaker, String topic, String descript, URL link){
		this.review = review;
		this.title = title;
		this.speaker = speaker;
		this.topic = topic;
		this.description = descript;
		this.link = link;
	}
	
	public Review getReview(int index){
		Review review = this.review.get(index);
		return review;
	}
	public String getTitle(){
		return title;
	}
	public String getSpeaker(){
		return speaker;
	}
	public String getDescript(){
		return description;
	}
	public URL getLink(){
		return link;
	}
	public String getTopic(){
		return topic;
	}
}
