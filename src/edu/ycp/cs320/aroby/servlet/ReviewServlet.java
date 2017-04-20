
package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.model.TedTalk;
import edu.ycp.cs320.aroby.controller.ReviewController;

public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/reviewPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Review model = new Review();
		Account acc = new Account();
		ReviewController controller = new ReviewController();
		TedTalk talk = new TedTalk();
		int rating;
		
			acc.setAccountId(acc.getAccountId());
			talk.setTedTalkId(talk.getTedTalkId());
			ZonedDateTime current = ZonedDateTime.now();
			String name = req.getParameter("name");
			String review = req.getParameter("review");
			String recommendations = req.getParameter("recommendations");
			String rating_string = req.getParameter("rating");
			if(rating_string != "" & rating_string != null){
			    rating = Integer.parseInt(rating_string);
				model.setRating(rating);
				model.setReview(review);
				model.setDate(current);
				model.setRecommendation(recommendations);
				model.setReviewId(model.getReviewId());
				model.setTedTalkId(talk.getTedTalkId());
				model.setAccountId(acc.getAccountId());
			}
			controller.setModel(model);
			String errorMessage = null;
			
			if(name == "" || review == ""  || rating_string == ""){
				req.setAttribute("model", model);
				req.getRequestDispatcher("/_view/reviewPage.jsp").forward(req, resp);
				errorMessage = "Complete all required fields";
			}
			else{
				System.out.print("Your review was submitted");
				resp.sendRedirect("/aroby/readPage");
			}	
	}
}