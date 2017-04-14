package edu.ycp.cs320.aroby.model;

import java.net.URL;
import java.util.ArrayList;

public class TedTalk {
	private URL link;
	private int tedTalk_id;
	private String title, speaker, topic, description;
	private ArrayList<Review> review = new ArrayList<Review>();
	
	public URL getLink() {
		return link;
	}
	public void setLink(URL link) {
		this.link = link;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<Review> getReview() {
		return review;
	}
	
	public void setReview(ArrayList<Review> review) {
		this.review = review;
	}
	
	public String getTopic() {
		return topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSpeaker() {
		return speaker;
	}
	
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public int getTedTalkId() {
		return tedTalk_id;
	}
	public void setTedTalkId(int tedTalk_id) {
		this.tedTalk_id = tedTalk_id;
	}
}
