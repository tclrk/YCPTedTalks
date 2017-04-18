package edu.ycp.cs320.aroby.controller;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.model.Review;

public class ReviewControllerTest {
	private Review model1, model2;
	private ReviewController controller1, controller2;
	
	@Before
	public void setUp() throws Exception {
		model1 = new Review();
		controller1 = new ReviewController();
		
		model1.setAccountId(1);
		model1.setRating(4);
		model1.setRecommendation("It's complicated.");
		model1.setReview("This talk was innappropriate for certain ages.");
		model1.setReviewId(3);
		model1.setTedTalkId(1);
		
		controller1.setModel(model1);
	}
	
	@Test
	public void test_isDone(){
		assertTrue(controller1.isDone());
	}
}
