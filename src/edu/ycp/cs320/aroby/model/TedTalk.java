package edu.ycp.cs320.aroby.model;

import java.net.URL;
import java.util.ArrayList;

public class TedTalk {
	private URL link;
	private String title, author, topic, descript;
	private ArrayList<Review> reviews = new ArrayList<Review>();
	
	public void setTedTalk(String title, String author, String topic, String descript, URL link){
		this.title = title;
		this.author = author;
		this.topic = topic;
		this.descript = descript;
		this.link = link;
	}
	
	public ArrayList <Review> getReviews(){
		reviews.add(reviews.get(0));
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
	public URL getLink(){
		return link;
	}
	public String getTopic(){
		return topic;
	}
}
