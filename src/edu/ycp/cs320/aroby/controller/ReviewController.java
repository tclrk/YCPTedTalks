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
		if(model.getReview() != null || model.getDescription() != null|| model.getTopic() != null ||  model.getName() != null ||  model.getAuthor() != null||  model.getLink() != null){
			return true;
		}
		else{
			return false;
		}
	}
}