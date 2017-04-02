package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


import edu.ycp.cs320.aroby.controller.ReadAReviewController;
import edu.ycp.cs320.aroby.model.ReadAReview;

public class ReadAReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/ReadAReview.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ReadAReview model = new ReadAReview(null, null, null, null, null, null);

		ReadAReviewController controller = new ReadAReviewController();
		controller.setModel(model);
		
		req.setAttribute("topic", req.getParameter(model.getTopic()));
		req.setAttribute("reviewText", req.getParameter(model.getReviewText()));
		req.setAttribute("name", req.getParameter(model.getName()));
		req.setAttribute("reviewText", req.getParameter(model.getAuthor()));
		req.setAttribute("Descript", req.getParameter(model.getDescript()));
		req.setAttribute("Link", req.getParameter(model.getLink()));
		
		
		req.getRequestDispatcher("/_view/ReadAReview.jsp").forward(req, resp);
	}

}
