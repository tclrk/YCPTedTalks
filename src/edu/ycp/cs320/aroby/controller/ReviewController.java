package edu.ycp.cs320.aroby.controller;

import edu.ycp.cs320.aroby.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.aroby.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.aroby.booksdb.persist.IDatabase;
import edu.ycp.cs320.aroby.model.Review;

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
	
	public Boolean isCorrect(){
		if(model.getAccountId() != 0 || model.getRating() > 0 || model.getRating() < 5 || model.getRecommendation() != "" || model.getReview() != "" || model.getReviewId() != 0 
				|| model.getTedTalkId() != 0){
			return true;
		}
		else{
			return false;
		}
	}
}
