package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.model.Speaker;
import edu.ycp.cs320.aroby.controller.ReviewController;
import edu.ycp.cs320.aroby.controller.TedTalkController;
import edu.ycp.cs320.aroby.model.TedTalk;
import edu.ycp.cs320.aroby.model.Topic;

public class TedTalkServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/_view/tedTalkPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Review model = new Review();
		ReviewController control = new ReviewController();
		TedTalk talk = new TedTalk();
		TedTalkController controller = new TedTalkController();
		int rating = 0;
		
		String errorMessage = null;
		
		ArrayList<Review> review = new ArrayList<Review>();
		
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String url_string = req.getParameter("link");
		String topic = req.getParameter("topic");
		String author = req.getParameter("author");
		String review_1 = req.getParameter("review");
		ZonedDateTime date = ZonedDateTime.now();
		String rating_s =req.getParameter("rating");
		if(rating_s != "" & rating_s != null){
			rating = Integer.parseInt(rating_s);
		}
		
		//start setting up shit 
		controller.insertNewTopic(topic);
		Topic real_top = controller.findTopic(topic);
		
		int ind = author.indexOf(" ");
		String firstname = author.substring(0, ind+1);
		String lastname = author.substring(ind+1);
		controller.insertNewSpeaker(firstname, lastname);
		Speaker speaker = controller.findSpeaker(firstname, lastname);
		
		model.setReview(review_1);
		model.setDate(date);
		model.setReviewId(1);
		model.setRating(rating);
		control.setModel(model);
		
		review.add(model);
		
		talk.setDescription(description);
		talk.setLink(url_string);
		talk.setTitle(title);
		talk.setSpeakerId(speaker.getSpeakerId());
		talk.setTopicId (real_top.getTopicId());
		talk.setReview(review);
		
		controller.setTalk(talk);
		model.setTedTalkId(talk.getTedTalkId());
		
			if(title != "" || description != "" || url_string != null 
					|| topic != "" || author != null || review_1 != null){
					//find if ted talk page exists within database 
					TedTalk t = controller.findTedTalkbyTitle(title);
					if(t.getTitle() == talk.getTitle() && t.getLink() == talk.getLink()){
						errorMessage = "TedTalk already exists.";
					}
					else{
						controller.insertNewTedTalk(talk.getTitle(), talk.getDescription(), talk.getLink(), speaker.getFirstname(), speaker.getLastname(), real_top.getTopic());
					}
			}
		req.setAttribute("model", talk);
		resp.sendRedirect("/aroby/index");
	}
}
