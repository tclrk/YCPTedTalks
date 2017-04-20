package edu.ycp.cs320.aroby.booksdb.persist;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Student;
import edu.ycp.cs320.aroby.model.TedTalk;
import edu.ycp.cs320.aroby.model.Topic;
import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.model.Speaker;

public class DerbyDatabaseTest {
	private IDatabase db = null;
	
	// WARNING: Make sure you drop the database before doing these tests!
	@Before
	public void setup() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	
	@Test
	public void FindAccountTest() { //good
		Account account = new Account();
		
		account = db.findAccount("aroby@ycp.edu");
		
		if(account == null) {
			fail("No account retrieved.");
		} else if(account.getEmail().equals("aroby@ycp.edu")) {
			System.out.println("Account found.");
		}
		
		account = db.findAccount("clocke3@ycp.edu");
		
		if(account.getEmail().equals("clocke3@ycp.edu")) {
			System.out.println("Account found.");
		} else {
			fail("Account not retrieved successfully.");
		}
	}
	
	@Test
	public void FindStudentTest() { //good
		Student student = new Student();
		
		student = db.findStudent("student@ycp.edu");
		
		if(student.getEmail().equals("student@ycp.edu")) {
			System.out.println("Student account retrieved.");
		} else {
			fail("Account not retrieved successfully.");
		}
	}
	
	@Test
	public void CreateAccountTest() { //good
		Account account = new Account();
		account.setAdmin(true);
		account.setEmail("test@ycp.edu");
		account.setFirstName("Tester");
		account.setLastName("Testinghouse");
		account.setPassword("test");
		
		Boolean result = db.createNewAccount(account.getEmail(), account.getPassword(), 
				account.getFirstName(), account.getLastName(), account.getAdmin());
		
		// Make sure the account was created, as intended
		if (result == true) {
			System.out.println("Successfully created new account.");
		} else {
			fail("Account not created successfully.");
		}
		
		// Set the email to an existing account
		account.setEmail("aroby@ycp.edu");
		
		result = db.createNewAccount(account.getEmail(), account.getPassword(), 
				account.getFirstName(), account.getLastName(), account.getAdmin());
		
		// Make sure the account WASN'T created, as intended
		if (result == false) {
			System.out.println("Account already exists. Success!");
		} else {
			fail("Oops, we created an account that already exists.");
		}
	}

	@Test
	public void CreateStudentTest() { //good
		Student account = new Student();
		account.setAdmin(false);
		account.setEmail("testStudent@ycp.edu");
		account.setFirstName("Tester");
		account.setLastName("Studentson");
		account.setPassword("test");
		
		account.setMajor("EE");
		account.setYCPId(001100);
		
		db.createNewAccount(account.getEmail(), account.getPassword(), 
				account.getFirstName(), account.getLastName(), account.getAdmin());
		
		Boolean result = db.createNewStudent(account.getYCPId(), account.getMajor(), account.getEmail());
		
		if (result == true) {
			System.out.println("Account created successfully.");
		} else {
			fail("Uh oh, the account wasn't created successfully.");
		}
	}
	
	@Test
	public void FindTopicTest() { //good
		Topic topic = new Topic();
		
		topic = db.findTopic("Engineering");
		
		if (topic == null) {
			fail("Topic not found!");
		} else {
			System.out.println("Topic found successfully.");
		}
	}
	
	@Test
	public void FindReviewsByAuthorTest() { //good
		List<Review> reviews = new ArrayList<Review>();
		
		reviews = db.findReviewsbyAuthor("Aaron", "Roby");
		
		if (reviews == null) {
			fail("No reviews found!");
		} else {
			System.out.println("Reviews found successfully.");
		}
	}
	
	@Test
	public void FindReviewsByTopicTest() { //good
		List<Review> reviews = new ArrayList<Review>();
		
		reviews = db.findReviewbyTopic("BS");
		
		if (reviews == null) {
			fail("No reviews found.");
		} else {
			System.out.println("Reviews found successfully.");
		}
	}
	
	@Test
	public void FindTedTalksByTitleTest() { //good
		List<TedTalk> talks = new ArrayList<TedTalk>();
		
		talks = db.findTedTalkbyTitle("BS");
		
		if(talks == null){
			fail("No ted talks found.");
		}
		else{
			System.out.println("TedTalks found succesfully!");
		}
	
	}
	@Test
	public void FindTedTalksBySpeakerTest() { //good
		List<TedTalk> talks = new ArrayList<TedTalk>();
		
		talks = db.findTedTalkbyAuthor("Roby");
		
		if(talks == null){
			fail("No ted talks found.");
		}
		else{
			System.out.println("TedTalks found succesfully!");
		}
	
	}
	
	@Test
	public void FindTedTalksByTopicTest() { //good
		List<TedTalk> talks = new ArrayList<TedTalk>();
		
		talks = db.findTedTalkbyTopic("Science");
		
		if(talks == null){
			fail("No ted talks found.");
		}
		else{
			System.out.println("TedTalks found succesfully!");
		}
	}
	
	@Test
	public void insertTedTalkTest() throws MalformedURLException {
		
		Speaker speaker = new Speaker();
		speaker.setFirstname("Betty");
		speaker.setLastname("Sue");
		
		Topic topic = new Topic();
		topic.setTopic("Ladybugs");
		
		ArrayList<Review> reviews = new ArrayList<Review>();
		Review rev = new Review();
		ZonedDateTime date = ZonedDateTime.now();
		rev.setReview("I love it");
		rev.setDate(date);
		rev.setRating(5);
		rev.setRecommendation("Watch if you want to be a kid");
		
		reviews.add(rev);
		
		TedTalk talk = new TedTalk();
		talk.setDescription("Great video");
		talk.setLink(new URL("https://docs.google.com/document/d/1sVaXM1ijR3_E03e-PIx3alpqa1TsHG6zuhbJQT__pRw/edit"));
		talk.setReview(reviews);
		talk.setTitle("Loser");
		
		db.insertNewSpeaker(speaker.getFirstname(), speaker.getLastname());
		Boolean result = db.insertNewTedTalk(talk.getTitle(), talk.getDescription(),talk.getLink(),speaker.getFirstname(), speaker.getLastname(), topic.getTopic());
		
		if (result == true) {
			System.out.println("Account created successfully.");
		} else {
			fail("Uh oh, the account wasn't created successfully.");
		}
	}
	
	@Test
	public void insertReviewTest() throws MalformedURLException {
		Account acc = new Account();
		acc.setFirstName("Chihea");
		acc.setLastName("Locke");
		acc.setAdmin(true);
		acc.setEmail("clocke3@ycp.edu");
		acc.setPassword("yomama");
		
		Review rev = new Review();
		rev.setDate(ZonedDateTime.now());
		rev.setRating(4);
		rev.setRecommendation("I love it");
		rev.setReview("You are a piece of shit.");
		ArrayList<Review> reviews = new ArrayList<Review>();
		reviews.add(rev);
		
		TedTalk talk = new TedTalk();
		talk.setLink(new URL("https://github.com/mailbox2112/YCPTedTalks/blob/master/src/edu/ycp/cs320/aroby/booksdb/persist/DerbyDatabase.java"));
		talk.setDescription("Fascinating");
		talk.setReview(reviews);
		talk.setTitle("Storybook");
		
		Boolean result = db.insertReview(rev.getRating(), rev.getDate(), rev.getReview(), rev.getRecommendation(), acc.getFirstName(), acc.getLastName(), talk.getTitle());

		if (result == true) {
			System.out.println("Speaker added successfully.");
		} else {
			fail("Uh oh, the speaker wasn't added successfully.");
		}
	}
	
	@Test
	public void insertNewSpeakerTest() { //good
		Speaker speaker = new Speaker();
		speaker.setFirstname("Hank");
		speaker.setLastname("Hill");
		
		Boolean result = db.insertNewSpeaker(speaker.getFirstname(), speaker.getLastname());
		
		if (result == true) {
			System.out.println("Speaker added successfully.");
		} else {
			fail("Uh oh, the speaker wasn't added successfully.");
		}
		
	}
	
	@Test
	public void insertNewTopicTest() { //good
		Topic topic = new Topic();
		topic.setTopic("Propane");
		
		Boolean result = db.insertNewTopic("Propane");
		
		if (result == true) {
			System.out.println("Topic added successfully.");
		} else {
			fail("Uh oh, the topic wasn't added successfully.");
		}
	}
}
