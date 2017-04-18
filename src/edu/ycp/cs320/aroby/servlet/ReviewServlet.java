package edu.ycp.cs320.aroby.servlet;

import java.awt.List;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.controller.ReviewController;
import edu.ycp.cs320.aroby.model.TedTalk;

public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/shortReviewPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Review model = new Review();
		ArrayList<Review> list = new ArrayList<Review>();
		ReviewController controller = new ReviewController();
		int rating;
		
		for(int i = 1; i < list.size(); i++){
			String review = req.getParameter("review");
			String recommendations = req.getParameter("recommendations");
			String rating_string = req.getParameter("rating");
			if(rating_string != "" & rating_string != null){
				rating = Integer.parseInt(rating_string);
				model.setReviewId(i);
				model.setTedTalkId(model.getTedTalkId());
				model.setDate(model.getDate());
				model.setRating(rating);
				model.setRecommendation(recommendations);
				model.setReview(review);
			}
			controller.setModel(model);
			String errorMessage = null;
			
			if(review == "" || recommendations == "" || rating_string == ""){
				req.setAttribute("model", model);
				req.getRequestDispatcher("/_view/shortReviewPage.jsp").forward(req, resp);
				errorMessage = "Complete all required fields";
			}
			else{
				controller.isDone();
				req.setAttribute("model", model);
				System.out.print("Your review was submitted");
				resp.sendRedirect("/aroby/index");
			}	
		}
	}
}
