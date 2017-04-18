package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.model.Review;
//set up tests
public class ReviewTest {
	private Review model1;
	private Review model2;
	private Review model3;

	
	@Before
	public void setUp() throws Exception {
		model1 = new Review();
		model2 = new Review();
		model3 = new Review();
		
		//separate setter methods
		model1.setAccountId(1);
		model2.setAccountId(5);
		model3.setAccountId(1);
		
		model1.setRating(3);
		model2.setRating(5);
		model3.setRating(1);
		
		model1.setRecommendation("I hate it");
		model2.setRecommendation("10/10 would recommend");
		model3.setRecommendation("I think the info was lacking");
		
		model1.setReview("I really liked it.");
		model2.setReview( "I can do it by myself.");
		model3.setReview("I'm interested in it.");
		
		model1.setReviewId(1);
		model2.setReviewId(7);
		model3.setReviewId(44);
		
		model1.setTedTalkId(1);
		model2.setTedTalkId(3);
		model3.setTedTalkId(33);
	}
	
	@Test
	public void test_getAccountId(){
		assertEquals(1, model1.getAccountId());
		assertEquals(5, model2.getAccountId());
		assertEquals(1, model3.getAccountId());
	}
	
	@Test
	public void test_getRating(){
		assertTrue(model1.getRating() == 3);
		assertTrue(model2.getRating() == 5);
		assertFalse(model3.getRating() == 4);
	}
	
	@Test
	public void test_getRecommendation(){
		assertEquals("I hate it", model1.getRecommendation());
		assertEquals("10/10 would recommend", model2.getRecommendation());
		assertEquals("I think the info was lacking", model3.getRecommendation());
	}
	
	@Test
	public void test_getReview(){
		assertEquals("I really liked it.", model1.getReview());
		assertEquals("I can do it by myself.", model2.getReview());
		assertEquals("I'm interested in it.", model3.getReview());
	}
	
	@Test
	public void test_getReviewId(){
		assertEquals(1, model1.getReviewId());
		assertEquals(7, model2.getReviewId());
		assertEquals(44, model3.getReviewId());
	}
	
	@Test
	public void test_getTedTalkId(){
		assertEquals(1, model1.getTedTalkId());
		assertEquals(3, model2.getTedTalkId());
		assertEquals(33, model3.getTedTalkId());
	}
	
}

