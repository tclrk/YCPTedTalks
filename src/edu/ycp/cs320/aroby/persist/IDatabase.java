package edu.ycp.cs320.aroby.persist;

import java.net.URL;
import java.sql.Date;
import java.util.List;

import edu.ycp.cs320.aroby.model.TedTalk;
import edu.ycp.cs320.aroby.controller.TedTalkController;
import edu.ycp.cs320.aroby.model.Topic;
import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.model.Search;
import edu.ycp.cs320.aroby.model.Speaker;
import edu.ycp.cs320.aroby.model.Student;

public interface IDatabase {
	//Chihea's 
	public Boolean insertNewTedTalk(String title, String description, String url, String firstname, String lastname, String topic);
	public Boolean insertNewSpeaker(String firstname, String lastname);
	public Boolean insertNewTopic(String top);
	public Boolean insertReview(int rating, String date, String review, String firstname, String lastname, String title);
	public List<TedTalk> findTedTalkbySpeaker(String search);
	public List<TedTalk> findTedTalkbyTopic(String search);
	public TedTalk findTedTalkbyTitle(String search);
	public TedTalk findTedTalkByID(int tedTalkID);
	public Topic findTopicbyID(int topicID);
	public Speaker findSpeakerbyID(int speakerID);

	
	// Me
	public Boolean createNewAccount(String email, String password, String firstname, String lastname, boolean admin);
	public Boolean createNewStudent(int ycp_id, String major, String email);
	public Account findAccount(String email);
	public Account findAccount(int accountId);
	public Student findStudent(String email);
	public TedTalk findTedTalkByReview(Review review);
	public List<Topic> getAllTopics();
	public List<Review> findReviewsbyAuthor(String firstname, String lastname);
	public List<Review> findReviewbyTopic(String topic);
	public List<Review> findReviewbyTitle(String title);
	public Topic findTopic(String topic);
	public Speaker findSpeaker(String firstname, String lastname);
	public Speaker findSpeakerFromTedTalk(int speakerId);
	public Boolean deleteTedTalk(int tedTalkId);
	public Boolean deleteReview(int reviewId);
	public Boolean changePassword(int accountId, String password);
	public Boolean changeEmail(int accountId, String email);
	public Boolean changeMajor(int studentId, String major);
	public Boolean deleteTables();
	public void loadInitialData();
	public void createTables();

}
