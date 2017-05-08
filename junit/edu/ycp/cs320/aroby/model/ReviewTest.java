package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;

import java.time.ZonedDateTime;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.model.Review;
//set up tests
public class ReviewTest {
	private Review model1;
	private String date;
	
	// TODO: Fix these!
	@Before
	public void setUp() throws Exception {
		model1 = new Review();
		date = ZonedDateTime.now().toLocalDate().toString();
		model1.setRating(2);
		model1.setDate(ZonedDateTime.now().toString());
		model1.setReview("I really liked it.");
		model1.setReviewId(1);
		model1.setTedTalkId(2);
		model1.setAccountId(3);
	}
	
	@Test
	public void test_AccountID(){
		assertEquals(3, model1.getAccountId());
	}
	
	@Test
	public void test_TedTalkId(){
		assertEquals(2, model1.getTedTalkId());
	}
	
	@Test
	public void test_getDate(){
		
		assertEquals(date, ZonedDateTime.parse(model1.getDate()).toLocalDate().toString());
		
	}
	
	@Test
	public void test_getReviewId(){
		assertEquals(1, model1.getReviewId());
	}
	
	@Test
	public void test_getReview(){
		assertEquals("I really liked it.", model1.getReview());
	}
	
	@Test
	public void test_getRating(){
		assertEquals(2, model1.getRating());
	}
}
