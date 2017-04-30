package edu.ycp.cs320.aroby.controller;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.model.TedTalk;

public class TedTalkControllerTest {
	private Review review;
	private ArrayList<Review> rList;
	private TedTalk talk;
	private TedTalkController control1;
	
	@Before
	public void setUp() throws Exception{
		review = new Review();
		rList = new ArrayList<Review>();
		talk =  new TedTalk();
		control1 = new TedTalkController();
		
		talk.setDescription("Lady Diana's death sparked a media frenzy and brought up discussion"
				+ "pertaining to paparazzi and private lives.");
		talk.setLink("http://www.gonegreek.com/comfort-colors-crewneck-with-greek-letters/");
		String review_string = "I really wish this conversation happened years ago";
		review.setReview(review_string);
		rList.add(review);
		
		talk.setReview(rList);
		talk.setSpeakerId(2);
		talk.setTedTalkId(74);
		talk.setTitle("Give Us Some Privacy!");
		talk.setTopicId(19);
		
		control1.setTalk(talk);
	}
	
	@Test
	public void test_exists(){
		assertTrue(!control1.exists());
	}
	
}
