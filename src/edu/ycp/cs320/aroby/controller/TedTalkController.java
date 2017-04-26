//come back to this later 

package edu.ycp.cs320.aroby.controller;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.aroby.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.aroby.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.aroby.booksdb.persist.IDatabase;
import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.model.Speaker;
import edu.ycp.cs320.aroby.model.TedTalk;
import edu.ycp.cs320.aroby.model.Topic;

public class TedTalkController {

	private Topic top;
	private Speaker speaker;
	private TedTalk ted_talk;
	private IDatabase db;
	
	public TedTalkController(){
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	public void setTalk(TedTalk ted_talk){
		this.ted_talk = ted_talk;
	}
	
	public boolean exists(){ 
		if (ted_talk.getDescription() != "" || ted_talk.getLink() != "" || ted_talk.getReview() != null || ted_talk.getTitle() != "" || ted_talk.getSpeakerId() > 0 || ted_talk.getTedTalkId() > 0 || ted_talk.getTopicId() > 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public Boolean insertNewSpeaker(String firstname, String lastname){
		 db.insertNewSpeaker(firstname, lastname);
		 return true;
	}
	
	public Speaker findSpeaker(String firstname, String lastname){
		speaker = db.findSpeaker(firstname, lastname);
		return speaker;
	}
	
	public Boolean insertNewTopic(String top){
		db.insertNewTopic(top);
		return true;
	}
	
	public Topic findTopic(String topic){
		top = db.findTopic(topic);
		return top;
	}
	
	public Account findAccount(int accountId){
		Account acc = db.findAccount(accountId);
		return acc;
	}
	
	public Boolean insertReview(int rating, String date, String review, String firstname, String lastname, String title){
		db.insertReview(rating, date, review, firstname, lastname, title);
		return true;
	}
	
	public Boolean insertNewTedTalk(String title, String description, String url, String firstname, String lastname, String topic){
		Boolean t = db.insertNewTedTalk(ted_talk.getTitle(), ted_talk.getDescription(), ted_talk.getLink(), firstname, lastname, topic);
		return t;
	}
	
	//may not need these methods because i dont need to search for anything
	public List<TedTalk> findTedTalkbyAuthor(String speaker){
		List<TedTalk> t1 = db.findTedTalkbyAuthor(speaker);
		return t1;
	}
	
	public TedTalk findTedTalkbyTitle(String title){
		TedTalk t2 = db.findTedTalkbyTitle(title);
		return t2;
	}

	public List<TedTalk> findTedTalkbyTopic(String topic){
		List<TedTalk> t3 = db.findTedTalkbyTopic(topic);
		return t3;
}
}
