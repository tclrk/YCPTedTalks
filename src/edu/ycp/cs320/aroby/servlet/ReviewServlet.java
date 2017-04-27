
package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		ReviewController controller = new ReviewController();
		Account acc = new Account();
		TedTalk talk = new TedTalk();
		ArrayList<Review> reviewList = new ArrayList<Review>();
		int rating = 0;
		
		ZonedDateTime current = ZonedDateTime.now();
		String review = req.getParameter("review");
		String rating_string = req.getParameter("rating");
		if(rating_string != "" & rating_string != null){
			rating = Integer.parseInt(rating_string);
		}
			
		//start setting shit up
		HttpSession session = req.getSession(true);
		String title = (String) session.getAttribute("title");
		Integer account_id = (Integer) session.getAttribute("accountId");
		
		talk = controller.findTedTalk(title);
		acc = controller.findAccount(account_id);
			
		model.setRating(rating);
		model.setReview(review);
		model.setDate(current);
		model.setReviewId(model.getReviewId());
		model.setTedTalkId(talk.getTedTalkId());
		model.setAccountId(acc.getAccountId());
		controller.setModel(model);
		reviewList.add(model);
		String errorMessage = null;
			
		if(review == ""  || rating_string == ""){
			errorMessage = "Complete all required fields";
		}
		else{
			controller.insertReview(model.getRating(), model.getDate(), model.getReview(), acc.getFirstName(), acc.getLastName(), title);
			req.setAttribute("model", model);
			System.out.print("Your review was submitted");
			resp.sendRedirect("/aroby/index");
		}	
	}
}