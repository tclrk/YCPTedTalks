package edu.ycp.cs320.aroby.model;

import java.net.URL;
import java.util.ArrayList;

public class TedTalk {
	private String title, link, author, topic, descript;
	private ArrayList<Review> reviews = new ArrayList<Review>();
	
	public void setTedTalk(String title, String author, String topic, String descript, String link){
		this.title = title;
		this.author = author;
		this.topic = topic;
		this.descript = descript;
		this.link = link;
	}
	
	public ArrayList <Review> getReviews(){
		for (int i = 0; i < reviews.size(); i++){
			reviews.add(reviews.get(i));
		}
		return reviews;
	}
	public String getTitle(){
		return title;
	}
	public String getAuthor(){
		return author;
	}
	public String getDescript(){
		return descript;
	}
	public String getLink(){
		return link;
	}
	public String getTopic(){
		return topic;
	}
}
