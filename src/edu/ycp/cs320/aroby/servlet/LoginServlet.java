package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.aroby.controller.NumbersController;
import edu.ycp.cs320.aroby.model.Numbers;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/_view/multiplyNumbers.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		Double result = null;
		Numbers model = new Numbers();
		NumbersController controller = new NumbersController();
		controller.setModel(model);
		
		try {
			Double first = getDoubleFromParameter(req.getParameter("first"));
			Double second = getDoubleFromParameter(req.getParameter("second"));

			if (first == null || second == null) {
				errorMessage = "Please specify two numbers";
			} else {
				model.setFirst(first);
				model.setSecond(second);
				result = controller.multiply();
			}
		} catch (NumberFormatException e) {
			errorMessage = "Invalid double";
		}

		// Add parameters as request attributes
		req.setAttribute("first", req.getParameter("first"));
		req.setAttribute("second", req.getParameter("second"));

		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", result);

		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/multiplyNumbers.jsp").forward(req, resp);
	}

	private Double getDoubleFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Double.parseDouble(s);
		}
	}
}
