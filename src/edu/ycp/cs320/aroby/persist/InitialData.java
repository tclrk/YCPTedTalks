package edu.ycp.cs320.aroby.persist;

import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.model.Speaker;
import edu.ycp.cs320.aroby.model.Student;
import edu.ycp.cs320.aroby.model.TedTalk;
import edu.ycp.cs320.aroby.model.Topic;

public class InitialData {
	
	public static List<Account> getAccounts() throws IOException {
		List<Account> accountList = new ArrayList<Account>();
		ReadCSV readAccounts = new ReadCSV("accounts.csv");
		try {
			Integer accountId = 1;
			while(true) {
				List<String> tuple = readAccounts.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Account account = new Account();
				
				// Throw away CSV file account id
				Integer.parseInt(i.next());
				// Auto-generate account id
				account.setAccountId(accountId++);
				// Load the rest of the info from the CSV file
				account.setEmail(i.next());
				account.setPassword(i.next());
				account.setFirstName(i.next());
				account.setLastName(i.next());
				account.setAdmin(Boolean.parseBoolean(i.next()));
				accountList.add(account);
			}
			System.out.println("Loaded accounts from accounts.csv");
			return accountList;
		} finally {
			readAccounts.close();
		}
	}
	
	public static List<Student> getStudents() throws IOException {
		List<Student> studentList = new ArrayList<Student>();
		ReadCSV readStudents = new ReadCSV("students.csv");
		try {
			Integer student_id = 1;
			while(true) {
				List<String> tuple = readStudents.next();
				if(tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Student student = new Student();
				// Throw away CSV student id
				Integer.parseInt(i.next());
				// Get rest of the fields
				student.setStudentId(student_id++);
				student.setAccountId(Integer.parseInt(i.next()));
				student.setYCPId(Integer.parseInt(i.next()));
				student.setMajor(i.next());
				studentList.add(student);
			}
			System.out.println("Loaded students from students.csv");
			return studentList;
		} finally {
			readStudents.close();
		}
	}
	
	public static List<Topic> getTopics() throws IOException {
		List<Topic> topicList = new ArrayList<Topic>();
		ReadCSV readTopics = new ReadCSV("topics.csv");
		try {
			Integer topic_id = 1;
			while(true) {
				List<String> tuple = readTopics.next();
				if(tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Topic topic = new Topic();
				// Throw away the topic id
				Integer.parseInt(i.next());
				// Auto-assign ID and get the rest of the data
				topic.setTopicId(topic_id++);
				topic.setTopic(i.next());
				topicList.add(topic);
			}
			return topicList;
		} finally {
			readTopics.close();
		}
	}
	
	public static List<Speaker> getSpeakers() throws IOException {
		List<Speaker> speakerList = new ArrayList<Speaker>();
		ReadCSV readSpeakers = new ReadCSV("speakers.csv");
		try {
			Integer speaker_id = 1;
			while(true) {
				List<String> tuple = readSpeakers.next();
				if(tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Speaker speaker = new Speaker();
				// Throw away speaker id
				Integer.parseInt(i.next());
				// Auto-assign speaker id
				speaker.setSpeakerId(speaker_id++);
				speaker.setFirstname(i.next());
				speaker.setLastname(i.next());
				speakerList.add(speaker);
			}
			return speakerList;
		} finally {
			readSpeakers.close();
		}
	}
	
	public static List<TedTalk> getTedTalks() throws IOException {
		List<TedTalk> tedTalkList = new ArrayList<TedTalk>();
		ReadCSV readTedTalks = new ReadCSV("tedtalks.csv");
		try {
			Integer tedtalk_id = 1;
			while(true) {
				List<String> tuple = readTedTalks.next();
				if(tuple == null){
					break;
				}
				Iterator<String> i = tuple.iterator();
				TedTalk talk = new TedTalk();
				// Throw away the TT id
				Integer.parseInt(i.next());
				// Auto-assign ID and get the rest of our data
				talk.setTedTalkId(tedtalk_id++);
				talk.setSpeakerId(Integer.parseInt(i.next()));
				talk.setTopicId(Integer.parseInt(i.next()));
				talk.setTitle(i.next());
				talk.setDescription(i.next());
				talk.setLink(i.next());
				tedTalkList.add(talk);
			}
			return tedTalkList;
		} finally {
			readTedTalks.close();
		}
	}
	
	public static List<Review> getReviews() throws IOException{
		List<Review> reviewList = new ArrayList<Review>();
		ReadCSV readReviews = new ReadCSV("reviews.csv");
		try {
			Integer review_id = 1;
			while(true) {
				List<String> tuple = readReviews.next();
				if(tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Review review = new Review();
				// Throw away review id
				Integer.parseInt(i.next());
				// Auto assign id and get the rest of the data
				review.setReviewId(review_id++);
				review.setAccountId(Integer.parseInt(i.next()));
				review.setTedTalkId(Integer.parseInt(i.next()));
				review.setRating(Integer.parseInt(i.next()));
				review.setDate((i.next()));
				review.setReview(i.next());
				reviewList.add(review);
			}
			return reviewList;
		} finally {
			readReviews.close();
		}
	}
}