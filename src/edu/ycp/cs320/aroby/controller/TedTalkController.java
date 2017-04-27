//come back to this later 

package edu.ycp.cs320.aroby.controller;

import edu.ycp.cs320.aroby.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.aroby.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.aroby.booksdb.persist.IDatabase;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.model.TedTalk;

public class TedTalkController {
	private IDatabase db;
	private TedTalk ted_talk;
	private TedTalk model;
	
	public TedTalkController(){
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	public void setModel(TedTalk model) {
		this.model = model;
	}
	public TedTalk getTedTalk() {
		return model;
	}
	
	public void set_TedTalk(String title, String description, int tedTalk_id, int speaker_id, int topic_id, String link, ArrayList<Review> review){
		ted_talk.setDescription(description);
		ted_talk.setLink(link);
		ted_talk.setReview(review);
		ted_talk.setSpeakerId(speaker_id);
		ted_talk.setTedTalkId(tedTalk_id);
		ted_talk.setTitle(title);
		ted_talk.setTopicId(topic_id);	
	}
	
	public boolean exists(){
		if (ted_talk.getTedTalkId() == 0){
			return false;
		}
		else{
			return true;
		}
	}
	public Account findAccount(int id) {
		Account a = db.findAccount(id);
		
		return a;
	}
	public List<Review> findReviewbyTitle(String title) {
		List<Review> t = db.findReviewbyTitle(title);
		
		return t;
	}
	
}
