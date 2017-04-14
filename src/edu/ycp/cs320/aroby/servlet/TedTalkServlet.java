package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.controller.ReviewController;
import edu.ycp.cs320.aroby.model.TedTalk;

public class TedTalkServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/_view/tedTalkPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Review model = new Review();
		ReviewController controller = new ReviewController();
		controller.setModel(model);
		TedTalk talk = new TedTalk();
		talk.setTedTalk(model.getAuthor(), model.getTitle(), model.getTopic(), model.getDescription(), model.getLink());
		talk.getReviews();
		String errorMessage = null;
		
		if(talk.equals(null)){
			errorMessage = "no such Ted Talk exists";
		}
		else{
			req.setAttribute("talk", talk);
			req.getRequestDispatcher("/_view/tedTalkPage.jsp").forward(req, resp);
		}
	}
}
