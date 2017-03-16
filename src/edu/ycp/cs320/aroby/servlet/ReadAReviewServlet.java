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
		ReadAReview model = new ReadAReview();

		ReadAReviewController controller = new ReadAReviewController();
		controller.setModel(model);
		
		req.setAttribute("top", req.getParameter(model.getTopic()));
		req.setAttribute("txt", req.getParameter(model.getReviewText()));
		req.setAttribute("rate", model.getRating());
		req.setAttribute("date", model.getDate());
		
		req.getRequestDispatcher("/_view/ReadAReview.jsp").forward(req, resp);
	}

}
