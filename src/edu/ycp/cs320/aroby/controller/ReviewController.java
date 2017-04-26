package edu.ycp.cs320.aroby.controller;

import edu.ycp.cs320.aroby.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.aroby.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.aroby.booksdb.persist.IDatabase;
import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.model.Speaker;
import edu.ycp.cs320.aroby.model.TedTalk;

// TODO: Fix this!
public class ReviewController {
	private Review model;
	private IDatabase db;

	/**
	 * Set the model.
	 * 
	 * @param model the model to set
	 */
	
	public ReviewController() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	public void setModel(Review model) {
		this.model = model;
	}
	
	public Review getReview(){
		return model;
	}
	public Account findAccount(int accountId){
		Account acc = db.findAccount(accountId);
		return acc;
	}
	
	public TedTalk findTedTalk(String title){
		TedTalk t = db.findTedTalkbyTitle(title);
		return t;
	}
	public Boolean insertReview(int rating, String date, String review, String firstname, String lastname, String title){
		Boolean r = db.insertReview(rating, date, review, firstname, lastname, title);
		return r;
	}
	
	public Speaker findSpeaker(String firstname, String lastname){
		Speaker spec = db.findSpeaker(firstname, lastname);
		return spec;
	}
	
	public Boolean isCorrect(){
		if(model.getAccountId() != 0 || model.getRating() > 0 || model.getRating() < 5 || model.getReview() != "" || model.getReviewId() != 0 
				|| model.getTedTalkId() != 0){
			return true;
		}
		else{
			return false;
		}
	}
}
