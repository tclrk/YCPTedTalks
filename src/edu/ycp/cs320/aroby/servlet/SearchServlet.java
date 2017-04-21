package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.model.Search;
import edu.ycp.cs320.aroby.model.TedTalk;
import edu.ycp.cs320.aroby.controller.SearchController;
import java.util.ArrayList;
import java.util.List;


public class SearchServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/searchPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		String errorMessage = null;
	
		Search model = new Search();
		SearchController controller = new SearchController();
		
		// Search is the LEFTMOST box
		String search = req.getParameter("search");
		// ExtraSearch is RIGHTMOST box
		String extraSearch = req.getParameter("extraSearch");
		String dropDownSelection = req.getParameter("options");
		
		model.setSearch(search);
		model.setExtraSearch(extraSearch);
		
		
		if(model.getSearch() != "" && model.getSearch() != null){
			controller.setModel(model);
			List<Review> reviews = new ArrayList<Review>();
			List<Account> accounts = new ArrayList<Account>();
			List<TedTalk> tedTalks = new ArrayList<TedTalk>();
			
			// Check what they selected from the drop down
			// If we selected authors, we'll find reviews by author
			if(dropDownSelection.equals("author")) {
				reviews = controller.findReviewsByAuthor(model.getSearch(), model.getExtraSearch());
				accounts = controller.getAccountFromReview(reviews);
				for(Review review : reviews) {
					TedTalk talk = controller.getTedTalkFromReview(review);
					tedTalks.add(talk);
				}
			// If not, we'll find them by topic
			} else if(dropDownSelection.equals("topic")) {
				reviews = controller.findReviewsByTopic(search);
				accounts = controller.getAccountFromReview(reviews);
				for(Review review : reviews) {
					TedTalk talk = controller.getTedTalkFromReview(review);
					tedTalks.add(talk);
				}
			// Or by title
			} else if(dropDownSelection.equals("title")) {
				reviews = controller.findReviewsByTitle(search);
				accounts = controller.getAccountFromReview(reviews);
				for(Review review : reviews) {
					TedTalk talk = controller.getTedTalkFromReview(review);
					tedTalks.add(talk);
				}
			}
			
			// Put the lists into the session info, then go back to the search page
			HttpSession session = req.getSession();
			session.setAttribute("reviews", reviews);
			session.setAttribute("accounts", accounts);
			session.setAttribute("tedTalks", tedTalks);
			req.getRequestDispatcher("/_view/searchPage.jsp").forward(req, resp);
		} else if(req.getParameter("readReview") != null) {
			// Get the session
			HttpSession session = req.getSession();
			// Get the reviews and selected review id from the session
			List<Review> reviews = (List<Review>)session.getAttribute("reviews");
			Integer reviewId = (Integer)session.getAttribute("reviewPage");
			
			// Create a review object to hold the review we want
			Review reviewToRead = new Review();
			
			// Iterate through the reviews until we find the one we need
			for(Review review : reviews) {
				if(review.getReviewId() == reviewId) {
					reviewToRead = review;
				}
			}
			
			// Remove unnecessary session info, add the review to the session
			session.removeAttribute("reviews");
			session.removeAttribute("reviewPage");
			session.setAttribute("review", reviewToRead);
		}
		else {
			errorMessage = "Type in something!";
		}
		
	}
}
