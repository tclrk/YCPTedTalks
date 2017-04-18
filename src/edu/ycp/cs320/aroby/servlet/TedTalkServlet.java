package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Speaker speaker = new Speaker();
		Topic topic = new Topic();
		TedTalk talk = new TedTalk();
		URL link = null;
		Review review = new Review();
		ArrayList<Review> reviewList = new ArrayList<Review>();
		TedTalkController controller = new TedTalkController();
		ArrayList<TedTalk> list = new ArrayList<TedTalk>();
		
		for(int i = 1; i < list.size(); i++){
			String description = req.getParameter("description");
			String title = req.getParameter("title");
			String review_string = req.getParameter("review");
			review.setReview(review_string);
			reviewList.add(review);
			talk.setDescription(description);
			String link_string = req.getParameter("link");
			link = new URL(link_string);
			talk.setLink(link);
			talk.setTitle(title);
			talk.setTedTalkId(i);
			talk.setReview(reviewList);
		//find their IDs from database	
			//talk.setTopicId();
			//talk.setSpeakerId();
			controller.set_TedTalk(talk.getDescription(), talk.getTitle(), talk.getTedTalkId(), talk.getTopicId(), talk.getSpeakerId(), talk.getLink(),talk.getReview());
			String errorMessage = null;
		
			req.setAttribute("model", talk);
			System.out.print("TedTalk submitted.");
			list.add(talk);
			resp.sendRedirect("/aroby/index");
			}
		}	
	}
