package edu.ycp.cs320.aroby.controller;

import edu.ycp.cs320.aroby.model.Review;

/**
 * Controller for the guessing game.
 */
public class ReviewController {
	private Review model;

	/**
	 * Set the model.
	 * 
	 * @param model the model to set
	 */
	public void setModel(Review model) {
		this.model = model;
	}
	
	public boolean isDone(){
		//if all the forms are filled out
		//come back to this
		
		if(model.getReview() != null || model.getAccountId() > 0 || model.getReviewId() > 0 ||  model.getTedTalkId() > 0 || model.getRecommendation() != null || model.getRating() > 0){
			return true;
		}
		else{
			return false;
		}
	}
}
