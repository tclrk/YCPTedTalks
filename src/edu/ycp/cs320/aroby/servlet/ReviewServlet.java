package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.aroby.model.Review;
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

		model.setReview(model.getTopic(), model.getName(), model.getAuthor(), model.getReview(), model.getDescription(), model.getLink());
		
		controller.setModel(model);
		String errorMessage = null;
		try{
			String name = req.getParameter("name");
			String author = req.getParameter("author");
			String description = req.getParameter("descript");
			String topic = req.getParameter("topic");
			String review = req.getParameter("review");
			String link = req.getParameter("link");
			
			if(name == "" || author == "" || description == "" || topic == "" || review == ""  || link == ""){
				errorMessage = "Complete all required fields";
			}
			else{
				controller.isDone();
				System.out.print("Your review was submitted");
			}
		}
		catch(NullPointerException e){
			errorMessage = "Found a parameter with a null pointer.";
		}
		req.setAttribute("Review", controller);
		
		req.getRequestDispatcher("/_view/reviewPage.jsp").forward(req, resp);
		
	}

	//private int getInteger(HttpServletRequest req, String name) {
		//return Integer.parseInt(req.getParameter(name));
	//}
}
