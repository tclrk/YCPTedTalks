package edu.ycp.cs320.aroby.servlet.ajax;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.aroby.controller.TedTalkController;
import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.model.Speaker;
import edu.ycp.cs320.aroby.model.TedTalk;
import edu.ycp.cs320.aroby.model.Topic;

public class TedTalkAjaxServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			doRequest(req, resp);
		}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			doRequest(req, resp);
		}

		private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// Get parameters
			Speaker speaker = new Speaker();
			Topic topic = new Topic();
			TedTalk talk = new TedTalk();
			URL link = null;
			Review review = new Review();
			ArrayList<Review> reviewList = new ArrayList<Review>();
			TedTalkController controller = new TedTalkController();
			ArrayList<TedTalk> list = new ArrayList<TedTalk>();
			
			String description = req.getParameter("description");
			String title = req.getParameter("title");
			String review_string = req.getParameter("review");
			review.setReview(review_string);
			
			// Use a controller to process the request
			reviewList.add(review);
			talk.setDescription(description);
			String link_string = req.getParameter("link");
			link = new URL(link_string);
			talk.setLink(link);
			//find IDs with database
			//talk.setTitle(title);
			//talk.setTedTalkId(i);
			talk.setReview(reviewList);
			//controller.set_TedTalk(title, description, tedTalk_id, speaker_id, topic_id, link, review);
			
			// Send back a response
			resp.setContentType("text/plain");
			resp.getWriter().println(controller.toString());
		}

		private Double getDouble(HttpServletRequest req, String name) {
			String val = req.getParameter(name);
			if (val == null) {
				return null;
			}
			try {
				return Double.parseDouble(val);
			} catch (NumberFormatException e) {
				return null;
			}
		}

		private void badRequest(String message, HttpServletResponse resp) throws IOException {
			resp.setContentType("text/plain");
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().println(message);
		}
	}
