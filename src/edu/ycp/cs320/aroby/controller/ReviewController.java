package edu.ycp.cs320.aroby.controller;

import edu.ycp.cs320.aroby.model.Review;

// TODO: Fix this!
public class ReviewController {
	private Review model;

	/**
	 * Set the model.
	 * 
	 * @param model the model to set
	 */
	public void setModel(Review model) {
		this.model = model;
		model.setAccountId(model.getAccountId());
		model.setRating(model.getRating());
		model.setRecommendation(model.getRecommendation());
		model.setReview(model.getReview());
		model.setReviewId(model.getReviewId());
		model.setTedTalkId(model.getTedTalkId());
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
