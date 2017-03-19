package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		if(req.getParameter("guessingGame") != null) {
			resp.sendRedirect("/aroby/guessingGame");
		} else if(req.getParameter("multiplyNumbers") != null) {
			resp.sendRedirect("/aroby/multiplyNumbers");
		} else if(req.getParameter("addNumbers") != null) {
			resp.sendRedirect("/aroby/addNumbers");
		} else if(req.getParameter("login") != null) {
			resp.sendRedirect("/aroby/login");
		} else if(req.getParameter("reviewPage") != null) {
			resp.sendRedirect("/aroby/reviewPage");
		}
	}
}
